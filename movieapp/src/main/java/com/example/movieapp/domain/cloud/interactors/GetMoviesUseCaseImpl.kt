package com.example.movieapp.domain.cloud.interactors

import com.example.movieapp.domain.cloud.MovieCloudRepository
import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse

class GetMoviesUseCaseImpl(private val repository: MovieCloudRepository) : GetMoviesUseCase {
    override suspend fun getPopularMovies(language: String, page: Int) =
        repository.getPopularMovies(language, page)

    override suspend fun getNowPlayingMovies(language: String, page: Int) =
        repository.getNowPlayingMovies(language, page)

    override suspend fun getTopRatedMovies(language: String, page: Int) =
        repository.getTopRatedMovies(language, page)

    override suspend fun getUpcomingMovies(language: String, page: Int) =
        repository.getUpcomingMovies(language, page)

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsModel =
        repository.getMovieDetails(movieId = movieId)

    override suspend fun getRecommendMovies(movieId: Int): MovieResponse =
        repository.getRecommendMovies(movieId = movieId)

    override suspend fun getSimilarMovies(movieId: Int): MovieResponse =
        repository.getSimilarMovies(movieId = movieId)

}