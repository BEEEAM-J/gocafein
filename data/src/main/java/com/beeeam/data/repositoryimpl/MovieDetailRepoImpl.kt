package com.beeeam.data.repositoryimpl

import com.beeeam.data.api.GocafeinApi
import com.beeeam.domain.model.HttpError
import com.beeeam.domain.model.MovieDetailResponse
import com.beeeam.domain.repository.MovieDetailRepo
import javax.inject.Inject

class MovieDetailRepoImpl @Inject constructor(
    private val api: GocafeinApi
): MovieDetailRepo {
    override suspend fun getMovieDetail(id: String): Result<MovieDetailResponse> {
        return try {
            val response = api.getMovieDetail(
                key = "954f1691",
                id = id,
            )
            when {
                response.isSuccessful -> {
                    Result.success(response.body()!!)
                }
                else -> {
                    Result.failure(HttpError(response.code(), response.errorBody()?.string() ?: ""))
                }
            }
        }
        catch (e: Exception) {
            Result.failure(e)
        }
    }
}