package com.beeeam.presentation.detail

import com.beeeam.domain.model.MovieDetail

data class DetailState(
    val isLoading: Boolean = true,
    val movieDetail: MovieDetail = MovieDetail(),
)

sealed interface DetailSideEffect {
    object PopBackStack: DetailSideEffect
}