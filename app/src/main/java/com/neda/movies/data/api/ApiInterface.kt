package com.neda.movies.data.api

import com.neda.movies.data.models.MovieApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //define all apis in this interface
    //https://imdb.iamidiotareyoutoo.com/search?q=matrix

    @GET("search")
    suspend fun searchMovie( @Query("q") q: String): MovieApiModel

}