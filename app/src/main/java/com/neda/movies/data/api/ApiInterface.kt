package com.neda.movies.data.api

import com.neda.movies.data.models.MovieApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    // OMDB API with demo key
    @GET("/")
    suspend fun searchMovie(
        @Query("s") search: String,
        @Query("apikey") apiKey: String = "thewdb"
    ): MovieApiModel
}