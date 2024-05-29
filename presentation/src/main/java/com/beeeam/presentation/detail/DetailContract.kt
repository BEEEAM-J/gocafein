package com.beeeam.presentation.detail

import com.beeeam.domain.model.MovieDetailResponse

data class DetailState(
    val movieDetail: MovieDetailResponse = MovieDetailResponse(),
)

sealed interface DetailSideEffect {}