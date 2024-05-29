package com.beeeam.domain.usecase

import com.beeeam.domain.model.MovieDetailResponse
import com.beeeam.domain.repository.MovieDetailRepo

class GetMovieDetailUseCase (
    private val repo: MovieDetailRepo,
) {
    suspend operator fun invoke(id: String): Result<MovieDetailResponse> {
        return repo.getMovieDetail(id)
    }
}