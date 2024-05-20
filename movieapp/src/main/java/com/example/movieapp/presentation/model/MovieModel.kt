package com.example.movieapp.presentation.model

import java.io.Serializable

class MovieModel(
    val adult: Boolean,
    val horizontalImage: String,
    val genreIdsList: List<Int>,
    val movieId: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val description: String,
    val popularity: Double,
    val posterImage: String,
    val releaseDate: String,
    val movieTitle: String,
    val voteAverage: Double,
    val voteCount: Int,
):Serializable