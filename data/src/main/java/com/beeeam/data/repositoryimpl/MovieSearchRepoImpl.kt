package com.beeeam.data.repositoryimpl

import com.beeeam.data.api.GocafeinApi
import com.beeeam.data.util.GocafeinApiCall
import com.beeeam.domain.model.MovieSearch
import com.beeeam.domain.repository.MovieSearchRepo
import javax.inject.Inject

class MovieSearchRepoImpl @Inject constructor(
    private val api: GocafeinApi
): MovieSearchRepo {
    override suspend fun getMovieList(title: String, page: Int): Result<MovieSearch> {
        return GocafeinApiCall {
            api.getMovieList(
                key = "954f1691",
                s = title,
                page = page,
                type = "movie",
            )
        }.mapCatching { response ->
            response.toModel()
        }
    }
}