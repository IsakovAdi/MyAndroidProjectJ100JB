package com.example.movieapp.presentation.model

class MovieResponseModel(
    val page: Int,
    val totalPages: Int,
    val totalResults: Int,
    val moviesList: List<MovieModel>,
) {
}