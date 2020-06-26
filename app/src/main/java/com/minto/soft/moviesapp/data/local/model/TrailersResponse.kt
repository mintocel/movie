package com.minto.soft.moviesapp.data.local.model

import com.google.gson.annotations.SerializedName


data class TrailersResponse (

    @SerializedName("results")
    var trailers: List<Trailer>? = null
)
