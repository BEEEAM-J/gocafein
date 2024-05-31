package com.beeeam.presentation.detail

import com.beeeam.domain.model.MovieDetailResponse

data class DetailState(
    val isLoading: Boolean = true,
    val movieDetail: MovieDetailResponse = MovieDetailResponse(),
)

sealed interface DetailSideEffect {
    object PopBackStack: DetailSideEffect
}