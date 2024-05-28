package com.beeeam.domain.model

data class SearchMovieResponse(
    val Response: String,
    val Search: List<MovieInfo>,
    val totalResults: String
)