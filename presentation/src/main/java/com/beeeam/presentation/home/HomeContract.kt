package com.beeeam.presentation.home

import com.beeeam.domain.model.MovieInfo

data class HomeState(
    val isLoading: Boolean = true,
    val searchValue: String = "star",
    val movieList: List<MovieInfo> = listOf(),
    val movieListPage: Int = 0,
)

sealed interface HomeSideEffect {
    data class NavigateToDetail(val id: String) : HomeSideEffect
    object ShowToastManyResult : HomeSideEffect
    object ShowToastNotFound : HomeSideEffect
}