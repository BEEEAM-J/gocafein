package com.beeeam.search

import com.beeeam.domain.model.MovieInfo

data class SearchState(
    val searchValue: String = "",
    val movieList: List<MovieInfo> = listOf()
)

sealed interface SearchSideEffect {}