package com.example.movieapp.presentation.mapper

import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.MovieDetailsModel
import com.example.movieapp.domain.model.MovieResponse
import com.example.movieapp.presentation.model.MovieDetailsUi
import com.example.movieapp.presentation.model.MovieModel
import com.example.movieapp.presentation.model.MovieResponseModel

class MapMovieFromDomainImpl() : MapMovieFromDomain {
    override fun mapMovie(from: Movie): MovieModel {
        return MovieModel(
            adult = from.adult ?: false,
            horizontalImage = from.horizontalImage ?: "",
            genreIdsList = from.genreIdsList ?: emptyList(),
            movieId = from.movieId ?: -1,
            originalLanguage = from.originalLanguage ?: "",
            originalTitle = from.originalTitle ?: "",
            description = from.description ?: "",
            popularity = from.popularity ?: 0.0,
            posterImage = from.posterImage ?: "",
            releaseDate = from.releaseDate ?: "",
            movieTitle = from.movieTitle ?: "",
            voteAverage = from.voteAverage ?: 0.0,
            voteCount = from.voteCount ?: 0,
        )
    }

    override fun mapMovieList(from: List<Movie>): List<MovieModel> = from.map { mapMovie(it) }

    override fun mapMovieResponse(from: MovieResponse): MovieResponseModel =
        MovieResponseModel(
            page = from.page ?: 0,
            totalPages = from.totalPages ?: 0,
            totalResults = from.totalResults ?: 0,
            moviesList = mapMovieList(from.moviesList ?: emptyList())
        )

    override fun mapMovieDetails(from: MovieDetailsModel): MovieDetailsUi =
        MovieDetailsUi(
            backdrop_path = from.backdrop_path ?: "",
            budget = from.budget,
            id = from.id,
            originalLanguage = from.originalLanguage,
            originalTitle = from.originalTitle,
            overview = from.overview ?: "",
            popularity = from.popularity,
            posterPath = from.posterPath ?: "",
            releaseDate = from.releaseDate,
            runtime = from.runtime ?: 0,
            status = from.status,
            title = from.title,
            video = from.video,
            voteAverage = from.voteAverage,
            voteCount = from.voteCount,
        )
}