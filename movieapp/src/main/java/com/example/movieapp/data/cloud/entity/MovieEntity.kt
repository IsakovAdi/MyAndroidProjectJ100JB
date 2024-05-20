package com.example.movieapp.data.cloud.entity

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("adult") val adult: Boolean? = null,
    @SerializedName("backdrop_path") val horizontalImage: String? = null,
    @SerializedName("genre_ids") val genreIdsList: List<Int>? = null,
    @SerializedName("id") val movieId: Int? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("overview") val description: String? = null,
    @SerializedName("popularity") val popularity: Double? = null,
    @SerializedName("poster_path") val posterImage: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("title") val movieTitle: String? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("vote_count") val voteCount: Int? = null,
)