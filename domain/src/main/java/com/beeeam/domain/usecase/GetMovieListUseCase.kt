package com.beeeam.domain.usecase

import com.beeeam.domain.model.MovieSearchResponse
import com.beeeam.domain.repository.MovieSearchRepo

class GetMovieListUseCase(
    private val repo: MovieSearchRepo,
) {
    suspend operator fun invoke(title: String, page: Int): Result<MovieSearchResponse> {
        return repo.getMovieList(title, page)
    }
}