package com.beeeam.domain.model

data class MovieSearch(
    val response: String = "",
    val search: List<MovieInfo> = listOf(),
    val totalResults: String = "",
    val error: String = "",
)

data class MovieInfo (
    val poster: String = "",
    val title: String = "",
    val type: String = "",
    val year: String = "",
    val movieId: String = "",
)