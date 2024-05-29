package com.beeeam.presentation.home

import com.beeeam.domain.model.MovieInfo

data class SearchState(
    val searchValue: String = "",
    val movieList: List<MovieInfo> = listOf()
)

sealed interface SearchSideEffect {}