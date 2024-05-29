package com.beeeam.domain.repository

import com.beeeam.domain.model.MovieDetailResponse

interface MovieDetailRepo {
    suspend fun getMovieDetail(id: String): Result<MovieDetailResponse>
}