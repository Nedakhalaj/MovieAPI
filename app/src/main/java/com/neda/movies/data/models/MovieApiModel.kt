package com.neda.movies.data.models

import com.google.gson.annotations.SerializedName

data class MovieApiModel (
    val ok : Boolean,
    val description : List<MovieDetailsApi>
)

data class MovieDetailsApi(

    @SerializedName("#TITLE")
    val title:String?,

    @SerializedName("#RANK")
    val rank: Double?,

    @SerializedName("#ACTORS")
    val actors:String?,

    @SerializedName("#IMG_POSTER")
    val posterUrl: String?

)


