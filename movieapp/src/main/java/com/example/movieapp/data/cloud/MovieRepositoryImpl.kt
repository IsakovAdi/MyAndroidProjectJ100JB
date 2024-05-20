package com.example.movieapp.data.cloud

import com.example.movieapp.data.cloud.source.MovieCloudDataSource
import com.example.movieapp.domain.cloud.MovieCloudRepository
import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse

class MovieRepositoryImpl(
    private val cloudDataSource: MovieCloudDataSource,
) : MovieCloudRepository {
    override suspend fun getPopularMovies(language: String, page: Int): MovieResponse =
        cloudDataSource.getPopularMovies(language, page)

    override suspend fun getNowPlayingMovies(language: String, page: Int): MovieResponse =
        cloudDataSource.getNowPlayingMovies(language, page)

    override suspend fun getUpcomingMovies(language: String, page: Int): MovieResponse =
        cloudDataSource.getUpcomingMovies(language, page)

    override suspend fun getTopRatedMovies(language: String, page: Int): MovieResponse =
        cloudDataSource.getTopRatedMovies(language, page)

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsModel =
        cloudDataSource.getMovieDetails(movieId = movieId)

    override suspend fun getRecommendMovies(movieId: Int): MovieResponse =
        cloudDataSource.getRecommendMovies(movieId = movieId)

    override suspend fun getSimilarMovies(movieId: Int): MovieResponse =
        cloudDataSource.getSimilarMovies(movieId = movieId)
}