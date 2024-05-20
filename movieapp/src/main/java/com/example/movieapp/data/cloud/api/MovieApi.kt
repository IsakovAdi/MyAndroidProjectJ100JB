package com.example.movieapp.data.cloud.api

import com.example.movieapp.data.cloud.entity.MovieDetailsEntity
import com.example.movieapp.data.cloud.entity.MovieResponseEntity
import com.example.movieapp.data.cloud.network.Endpoints
import org.intellij.lang.annotations.Language
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET(Endpoints.POPULAR)
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieResponseEntity

    @GET(Endpoints.NOW_PLAYING)
    suspend fun getNowPlayingMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieResponseEntity

    @GET(Endpoints.TOP_RATED)
    suspend fun getTopRatedMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieResponseEntity

    @GET(Endpoints.UPCOMING)
    suspend fun getUpcomingMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieResponseEntity


    @GET(Endpoints.MOVIE_DETAILS)
    suspend fun getMovieDetails(
        @Path("movie_id}") movieId: Int,
        @Query("language") language: String = "ru",
    ): MovieDetailsEntity

    @GET(Endpoints.SIMILAR_MOVIES)
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "ru",
        @Query("page") page: Int = 1,
    ): MovieResponseEntity

    @GET(Endpoints.RECOMMEND_MOVIES)
    suspend fun getRecommendMovies(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "ru",
        @Query("page") page: Int = 1,
    ): MovieResponseEntity
}