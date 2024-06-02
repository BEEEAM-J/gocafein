package com.beeeam.data.response

import com.google.gson.annotations.SerializedName

data class MovieSearchResponse(
    @SerializedName("Search") val search: List<MovieInfo> = listOf(),
    val totalResults: String = "",
): BaseResponse() {
    fun toModel()  = com.beeeam.domain.model.MovieSearch(
        search = search.map { it.toModel() },
        totalResults = totalResults,
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