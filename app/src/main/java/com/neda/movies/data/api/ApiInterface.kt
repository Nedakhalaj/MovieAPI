package com.neda.movies.data.api

import com.neda.movies.data.models.MovieApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    // Mock API for testing - returns fake data
    // This will help us test if the app logic works

    @GET("test")
    suspend fun searchMovie(
        @Query("q") search: String
    ): MovieApiModel

}