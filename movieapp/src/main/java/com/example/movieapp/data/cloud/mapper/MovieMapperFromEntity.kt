package com.example.movieapp.data.cloud.mapper

import com.example.movieapp.data.cloud.entity.MovieDetailsEntity
import com.example.movieapp.data.cloud.entity.MovieEntity
import com.example.movieapp.data.cloud.entity.MovieResponseEntity
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse

interface MovieMapperFromEntity {
    fun mapMovie(from: MovieEntity): Movie
    fun mapMovieList(from: List<MovieEntity>): List<Movie>
    fun mapMovieResponse(from: MovieResponseEntity): MovieResponse
    fun mapMovieDetails(from: MovieDetailsEntity): MovieDetailsModel
}