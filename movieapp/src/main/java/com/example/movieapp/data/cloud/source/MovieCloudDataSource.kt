package com.example.movieapp.data.cloud.source

import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse

interface MovieCloudDataSource {
    suspend fun getPopularMovies(language: String, page: Int): MovieResponse
    suspend fun getNowPlayingMovies(language: String, page: Int): MovieResponse
    suspend fun getTopRatedMovies(language: String, page: Int): MovieResponse
    suspend fun getUpcomingMovies(language: String, page: Int): MovieResponse

    suspend fun getMovieDetails(movieId: Int): MovieDetailsModel

    suspend fun getSimilarMovies(movieId: Int): MovieResponse
    suspend fun getRecommendMovies(movieId: Int): MovieResponse


}