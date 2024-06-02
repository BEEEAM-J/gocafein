package com.beeeam.data.response

import com.google.gson.annotations.SerializedName

data class MovieSearchResponse(
    @SerializedName("Response") val response: String = "",
    @SerializedName("Search") val search: List<MovieInfo> = listOf(),
    val totalResults: String = "",
    @SerializedName("Error") val error: String = "",
) {
    fun toModel()  = com.beeeam.domain.model.MovieSearch(
        response = response,
        search = search.map { it.toModel() },
        totalResults = totalResults,
        error = error,
    )
}

data class MovieInfo(
    @SerializedName("Poster") val poster: String = "",
    @SerializedName("Title") val title: String = "",
    @SerializedName("Type") val type: String = "",
    @SerializedName("Year") val year: String = "",
    @SerializedName("imdbID") val movieId: String = "",
) {
    fun toModel() = com.beeeam.domain.model.MovieInfo(
        poster = poster,
        title = title,
        type = type,
        year = year,
        movieId = movieId,
    )
}