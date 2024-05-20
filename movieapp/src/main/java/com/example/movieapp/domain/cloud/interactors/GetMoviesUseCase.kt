package com.example.movieapp.domain.cloud.interactors

import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse
import org.intellij.lang.annotations.Language

interface GetMoviesUseCase {
    suspend fun getPopularMovies(language: String, page: Int): MovieResponse
    suspend fun getNowPlayingMovies(language: String, page: Int): MovieResponse
    suspend fun getTopRatedMovies(language: String, page: Int): MovieResponse
    suspend fun getUpcomingMovies(language: String, page: Int): MovieResponse

    suspend fun getMovieDetails(movieId:Int):MovieDetailsModel
    suspend fun getRecommendMovies(movieId:Int):MovieResponse
    suspend fun getSimilarMovies(movieId:Int):MovieResponse
}