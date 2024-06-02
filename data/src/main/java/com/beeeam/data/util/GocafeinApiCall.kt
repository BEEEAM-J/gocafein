package com.beeeam.data.util

import com.beeeam.data.response.BaseResponse
import com.beeeam.domain.model.HttpError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.RuntimeException

suspend fun <T: BaseResponse> GocafeinApiCall(
    callFunction: suspend () -> Response<T>,
): Result<T> {
    return try {
        withContext(Dispatchers.IO) {
            val response = callFunction()
            val body = response.body()!!

            when {
                response.isSuccessful.not() -> Result.failure(HttpError(response.code(), response.errorBody()?.string() ?: ""))
                body.error != null -> Result.failure(RuntimeException(body.error))
                else -> Result.success(body)
            }
        }
    }
    catch (e: Exception) {
        Result.failure(e)
    }
}