package com.example.movieapp.domain.model

class Movie(
    val adult: Boolean? = null,
    val horizontalImage: String? = null,
    val genreIdsList: List<Int>? = null,
    val movieId: Int? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val description: String? = null,
    val popularity: Double? = null,
    val posterImage: String? = null,
    val releaseDate: String? = null,
    val movieTitle: String? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null,
)