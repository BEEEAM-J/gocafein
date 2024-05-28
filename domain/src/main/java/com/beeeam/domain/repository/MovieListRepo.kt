package com.beeeam.domain.repository

import com.beeeam.domain.model.SearchMovieResponse

interface MovieListRepo {
    suspend fun getMovieList(
        title: String,
        page: Int,
    ): Result<SearchMovieResponse>
}