package com.beeeam.domain.repository

import com.beeeam.domain.model.MovieSearchResponse

interface MovieSearchRepo {
    suspend fun getMovieList(
        title: String,
        page: Int,
    ): Result<MovieSearchResponse>
}