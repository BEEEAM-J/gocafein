package com.beeeam.data.api

import com.beeeam.data.response.MovieDetailResponse
import com.beeeam.data.response.MovieSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GocafeinApi {
    @GET("/")
    suspend fun getMovieList(
        @Query("apikey") key: String,
        @Query("s") s: String,
        @Query("page") page: Int,
        @Query("type") type: String,
    ): Response<MovieSearchResponse>

    @GET("/")
    suspend fun getMovieDetail(
        @Query("apikey") key: String,
        @Query("i") id: String,
    ): Response<MovieDetailResponse>
}