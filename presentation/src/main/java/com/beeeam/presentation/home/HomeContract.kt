package com.beeeam.presentation.home

import com.beeeam.domain.model.MovieInfo

data class HomeState(
    val searchValue: String = "",
    val movieList: List<MovieInfo> = listOf()
)

sealed interface HomeSideEffect {
    data class NavigateToDetail(val id: String) : HomeSideEffect
}