package com.beeeam.domain.repository

import com.beeeam.domain.model.MovieDetail

interface MovieDetailRepo {
    suspend fun getMovieDetail(id: String): Result<MovieDetail>
}