package com.beeeam.domain.usecase

import com.beeeam.domain.model.MovieSearch
import com.beeeam.domain.repository.MovieSearchRepo

class GetMovieListUseCase(
    private val repo: MovieSearchRepo,
) {
    suspend operator fun invoke(title: String, page: Int): Result<MovieSearch> {
        return repo.getMovieList(title, page)
    }
}