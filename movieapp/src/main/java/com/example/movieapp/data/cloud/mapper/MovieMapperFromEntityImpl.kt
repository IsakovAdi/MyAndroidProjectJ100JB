package com.example.movieapp.data.cloud.mapper

import com.example.movieapp.data.cloud.entity.MovieDetailsEntity
import com.example.movieapp.data.cloud.entity.MovieEntity
import com.example.movieapp.data.cloud.entity.MovieResponseEntity
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse

class MovieMapperFromEntityImpl : MovieMapperFromEntity {
    override fun mapMovie(from: MovieEntity): Movie {
        return Movie(
            adult = from.adult,
            horizontalImage = from.horizontalImage,
            genreIdsList = from.genreIdsList,
            movieId = from.movieId,
            originalLanguage = from.originalLanguage,
            originalTitle = from.originalTitle,
            description = from.description,
            popularity = from.popularity,
            posterImage = from.posterImage,
            releaseDate = from.releaseDate,
            movieTitle = from.movieTitle,
            voteAverage = from.voteAverage,
            voteCount = from.voteCount,
        )
    }

    override fun mapMovieList(from: List<MovieEntity>): List<Movie> = from.map { mapMovie(it) }

    override fun mapMovieResponse(from: MovieResponseEntity): MovieResponse {
        return MovieResponse(
            page = from.page,
            totalPages = from.totalPages,
            totalResults = from.totalResults,
            moviesList = from.moviesList?.let {
                mapMovieList(it)
            }?: emptyList()
        )
    }

    override fun mapMovieDetails(from: MovieDetailsEntity): MovieDetailsModel =
        MovieDetailsModel(
            backdrop_path = from.backdrop_path,
            budget = from.budget,
            id = from.id,
            originalLanguage = from.originalLanguage,
            originalTitle = from.originalTitle,
            overview = from.overview,
            popularity = from.popularity,
            posterPath = from.posterPath,
            releaseDate = from.releaseDate,
            runtime = from.runtime,
            status = from.status,
            title = from.title,
            video = from.video,
            voteAverage = from.voteAverage,
            voteCount = from.voteCount,
        )

}