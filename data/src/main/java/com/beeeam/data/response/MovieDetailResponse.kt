package com.beeeam.data.response

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("Actors") val actors: String = "",
    @SerializedName("Awards") val awards: String = "",
    @SerializedName("BoxOffice") val boxOffice: String = "",
    @SerializedName("Country") val country: String = "",
    @SerializedName("DVD") val dvd: String = "",
    @SerializedName("Director") val director: String = "",
    @SerializedName("Genre") val genre: String = "",
    @SerializedName("Language") val language: String = "",
    @SerializedName("Metascore") val metaScore: String = "",
    @SerializedName("Plot") val plot: String = "",
    @SerializedName("Poster") val poster: String = "",
    @SerializedName("Production") val production: String = "",
    @SerializedName("Rated") val rated: String = "",
    @SerializedName("Ratings") val ratings: List<Rating> = listOf(),
    @SerializedName("Released") val released: String = "",
    @SerializedName("Runtime") val runtime: String = "",
    @SerializedName("Title") val title: String = "",
    @SerializedName("Type") val type: String = "",
    @SerializedName("Website") val website: String = "",
    @SerializedName("Writer") val writer: String = "",
    @SerializedName("Year") val year: String = "",
    val imdbID: String = "",
    val imdbRating: String = "",
    val imdbVotes: String = ""
): BaseResponse() {
    fun toModel() = com.beeeam.domain.model.MovieDetail(
        actors = actors,
        awards = awards,
        boxOffice = boxOffice,
        country = country,
        dvd = dvd,
        director = director,
        genre = genre,
        language = language,
        metaScore = metaScore,
        plot = plot,
        poster = poster,
        production = production,
        rated = rated,
        ratings = ratings.map { it.toModel() },
        released = released,
        response = response,
        runtime = runtime,
        title = title,
        type = type,
        website = website,
        writer = writer,
        year = year,
        imdbID = imdbID,
        imdbRating = imdbRating,
        imdbVotes = imdbVotes,
    )
}

data class Rating(
    @SerializedName("Source") val source: String = "",
    @SerializedName("Value") val value: String = "",
) {
    fun toModel() = com.beeeam.domain.model.Rating(
        source = source,
        value = value,
    )
}