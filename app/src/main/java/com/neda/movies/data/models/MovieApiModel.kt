package com.neda.movies.data.models

import com.google.gson.annotations.SerializedName

data class MovieApiModel (
    @SerializedName("Search")
    val search: List<MovieDetailsApi>?,
    @SerializedName("totalResults")
    val totalResults: String?,
    @SerializedName("Response")
    val response: String?
)

data class MovieDetailsApi(

    @SerializedName("Title")
    val title:String?,

    @SerializedName("imdbRating")
    val rank: String?,

    @SerializedName("Actors")
    val actors:String?,

    @SerializedName("Poster")
    val posterUrl: String?

)


