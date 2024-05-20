package com.example.movieapp.data.cloud.entity

import com.google.gson.annotations.SerializedName

class MovieDetailsEntity(
    @SerializedName("backdrop_path") val backdrop_path: String? = null,
    @SerializedName("budget") val budget: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("runtime") val runtime: Int? = null,
    @SerializedName("status") val status: String,
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int,
)