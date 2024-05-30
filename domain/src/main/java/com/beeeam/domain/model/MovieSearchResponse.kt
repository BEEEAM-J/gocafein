package com.beeeam.domain.model

data class MovieSearchResponse(
    val Response: String,
    val Search: List<MovieInfo>,
    val totalResults: String,
    val Error: String,
)

data class MovieInfo(
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbID: String
)