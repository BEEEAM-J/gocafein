package com.beeeam.domain.model

data class MovieSearch(
    val search: List<MovieInfo> = listOf(),
    val totalResults: String = "",
)

data class MovieInfo (
    val poster: String = "",
    val title: String = "",
    val type: String = "",
    val year: String = "",
    val movieId: String = "",
)