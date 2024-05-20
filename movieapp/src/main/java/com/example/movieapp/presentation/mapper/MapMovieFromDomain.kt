package com.example.movieapp.presentation.mapper

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse
import com.example.movieapp.presentation.model.MovieDetailsUi
import com.example.movieapp.presentation.model.MovieResponseModel
import com.example.movieapp.presentation.model.MovieModel

interface MapMovieFromDomain {
    fun mapMovie(from: Movie): MovieModel
    fun mapMovieList(from: List<Movie>): List<MovieModel>
    fun mapMovieResponse(from: MovieResponse): MovieResponseModel
    fun mapMovieDetails(from: MovieDetailsModel):MovieDetailsUi
}