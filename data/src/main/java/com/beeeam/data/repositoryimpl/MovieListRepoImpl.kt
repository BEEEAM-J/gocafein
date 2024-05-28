package com.beeeam.data.repositoryimpl

import com.beeeam.data.api.GocafeinApi
import com.beeeam.domain.model.HttpError
import com.beeeam.domain.model.SearchMovieResponse
import com.beeeam.domain.repository.MovieListRepo
import javax.inject.Inject

class MovieListRepoImpl @Inject constructor(
    private val api: GocafeinApi
): MovieListRepo {
    override suspend fun getMovieList(
        title: String,
        page: Int)
    : Result<SearchMovieResponse> {
        return try {
            val response = api.getMovieList(
                key = "954f1691",
                s = title,
                page = page,
                type = "movie",
            )
            when {
                response.isSuccessful -> {
                    Result.success(response.body()!!)
                }
                else -> {
                    Result.failure(HttpError(response.code(), response.errorBody()?.string() ?: ""))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}