package com.beeeam.domain.repository

import com.beeeam.domain.model.MovieSearch

interface MovieSearchRepo {
    suspend fun getMovieList(
        title: String,
        page: Int,
    ): Result<MovieSearch>
}