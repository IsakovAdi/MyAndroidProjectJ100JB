package com.example.movieapp.data.cloud.network

object Endpoints {
//    const val API_KEY = "3249dba9ba8a81c53f42a124fe89e8e5"
    const val API_KEY = "3249dba9ba8a81c53f42a124fe89e8e5"

    const val BASE_URL = "https://api.themoviedb.org/3/"

    const val NOW_PLAYING = "movie/now_playing"
    const val POPULAR = "movie/popular"
    const val UPCOMING = "movie/upcoming"
    const val TOP_RATED = "movie/top_rated"
    const val SEARCH_MOVIE = "search/movie"

    const val MOVIE_DETAILS = "movie/{movie_id}"
    const val SIMILAR_MOVIES = "movie/{movie_id}/similar"
    const val RECOMMEND_MOVIES = "movie/{movie_id}/recommendations"

    const val GET_ALL_ACTORS = "person/popular"
    const val GET_PERSON_DETAILS = "person/{person_id}"
}