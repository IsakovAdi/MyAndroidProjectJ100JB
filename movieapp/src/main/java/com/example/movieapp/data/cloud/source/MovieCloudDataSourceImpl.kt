package com.example.movieapp.data.cloud.source

import com.example.movieapp.data.cloud.api.MovieApi
import com.example.movieapp.data.cloud.mapper.MovieMapperFromEntity
import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse

class MovieCloudDataSourceImpl(
    private val api: MovieApi,
    private val mapper: MovieMapperFromEntity,
) : MovieCloudDataSource {
    override suspend fun getPopularMovies(language: String, page: Int): MovieResponse {
        return mapper.mapMovieResponse(api.getPopularMovies(language = language, page = page))
    }

    override suspend fun getNowPlayingMovies(language: String, page: Int): MovieResponse {
        return mapper.mapMovieResponse(api.getNowPlayingMovies(language = language, page = page))
    }

    override suspend fun getTopRatedMovies(language: String, page: Int): MovieResponse {
        return mapper.mapMovieResponse(api.getTopRatedMovies(language = language, page = page))
    }

    override suspend fun getUpcomingMovies(language: String, page: Int): MovieResponse {
        return mapper.mapMovieResponse(api.getUpcomingMovies(language = language, page = page))
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsModel =
        mapper.mapMovieDetails(api.getMovieDetails(movieId))

    override suspend fun getSimilarMovies(movieId: Int): MovieResponse =
        mapper.mapMovieResponse(api.getSimilarMovies(movieId = movieId))

    override suspend fun getRecommendMovies(movieId: Int): MovieResponse =
        mapper.mapMovieResponse(api.getRecommendMovies(movieId = movieId))
}