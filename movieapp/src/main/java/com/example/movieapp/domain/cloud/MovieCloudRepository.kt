package com.example.movieapp.domain.cloud

import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse

interface MovieCloudRepository {

    suspend fun getPopularMovies(language: String, page: Int): MovieResponse
    suspend fun getNowPlayingMovies(language: String, page: Int): MovieResponse
    suspend fun getUpcomingMovies(language: String, page: Int): MovieResponse
    suspend fun getTopRatedMovies(language: String, page: Int): MovieResponse

    suspend fun getMovieDetails(movieId: Int):MovieDetailsModel
    suspend fun getRecommendMovies(movieId:Int):MovieResponse
    suspend fun getSimilarMovies(movieId:Int):MovieResponse


}