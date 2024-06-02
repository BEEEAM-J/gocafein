package com.beeeam.data.repositoryimpl

import com.beeeam.data.api.GocafeinApi
import com.beeeam.data.util.GocafeinApiCall
import com.beeeam.domain.model.MovieDetail
import com.beeeam.domain.repository.MovieDetailRepo
import javax.inject.Inject

class MovieDetailRepoImpl @Inject constructor(
    private val api: GocafeinApi
): MovieDetailRepo {
    override suspend fun getMovieDetail(id: String): Result<MovieDetail> {
        return GocafeinApiCall {
            api.getMovieDetail(
                key = "954f1691",
                id = id,
            )
        }.mapCatching { response ->
            response.toModel()
        }
    }
}