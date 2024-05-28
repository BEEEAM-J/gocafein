package com.beeeam.domain.usecase

import com.beeeam.domain.model.SearchMovieResponse
import com.beeeam.domain.repository.MovieListRepo

class GetMovieListUseCase(
    private val repo: MovieListRepo,
) {
    suspend operator fun invoke(title: String, page: Int): Result<SearchMovieResponse> {
        return repo.getMovieList(title, page)
    }
}