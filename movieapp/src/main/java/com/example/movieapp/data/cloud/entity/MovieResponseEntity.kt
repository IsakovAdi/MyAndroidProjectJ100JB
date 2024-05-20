package com.example.movieapp.data.cloud.entity

import com.google.gson.annotations.SerializedName

class MovieResponseEntity(
    @SerializedName("page") val page: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    @SerializedName("results") val moviesList: List<MovieEntity>? = null,
)