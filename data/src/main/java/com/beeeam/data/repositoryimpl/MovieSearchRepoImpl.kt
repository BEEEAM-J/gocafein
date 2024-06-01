package com.beeeam.data.repositoryimpl

import com.beeeam.data.api.GocafeinApi
import com.beeeam.domain.model.HttpError
import com.beeeam.domain.model.MovieSearch
import com.beeeam.domain.repository.MovieSearchRepo
import javax.inject.Inject

class MovieSearchRepoImpl @Inject constructor(
    private val api: GocafeinApi
): MovieSearchRepo {
    override suspend fun getMovieList(
        title: String,
        page: Int)
    : Result<MovieSearch> {
        return try {
            val response = api.getMovieList(
                key = "954f1691",
                s = title,
                page = page,
                type = "movie",
            )
            when {
                response.isSuccessful -> {
                    Result.success(response.body()!!.toModel())
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