package com.beeeam.domain.usecase

import com.beeeam.domain.model.MovieDetail
import com.beeeam.domain.repository.MovieDetailRepo

class GetMovieDetailUseCase (
    private val repo: MovieDetailRepo,
) {
    suspend operator fun invoke(id: String): Result<MovieDetail> {
        return repo.getMovieDetail(id)
    }
}