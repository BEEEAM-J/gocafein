package com.beeeam.data.util

import com.beeeam.domain.model.HttpError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T> GocafeinApiCall(
    callFunction: suspend () -> Response<T>,
): Result<T> {
    return try {
        withContext(Dispatchers.IO) {
            val response = callFunction()

            when {
                response.isSuccessful -> {
                    Result.success(response.body()!!)
                }
                else -> {
                    Result.failure(HttpError(response.code(), response.errorBody()?.string() ?: ""))
                }
            }

        }
    }
    catch (e: HttpException) {
        Result.failure(e)
    }
}