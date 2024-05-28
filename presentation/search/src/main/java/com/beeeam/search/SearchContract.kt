package com.beeeam.search

data class SearchState(
    val searchValue: String = ""
)

sealed interface SearchSideEffect {}