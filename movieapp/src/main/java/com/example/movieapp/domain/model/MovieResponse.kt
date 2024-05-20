package com.example.movieapp.domain.model

class MovieResponse(
    val page: Int? = null,
    val totalPages: Int? = null,
    val totalResults: Int? = null,
    val moviesList: List<Movie>? = null,
)