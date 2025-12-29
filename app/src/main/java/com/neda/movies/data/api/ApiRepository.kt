package com.neda.movies.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {

    lateinit var apiInterface: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://imdb.iamidiotareyoutoo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //API connection
        apiInterface = retrofit.create(ApiInterface::class.java)

    }

}