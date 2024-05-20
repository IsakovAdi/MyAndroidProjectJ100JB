package com.example.movieapp.presentation.ui.fragments.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.cloud.interactors.GetMoviesUseCase
import com.example.movieapp.presentation.mapper.MapMovieFromDomain
import com.example.movieapp.presentation.model.MovieDetailsUi
import com.example.movieapp.presentation.model.MovieModel
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val useCase: GetMoviesUseCase,
    private val mapper: MapMovieFromDomain,
) : ViewModel() {

    private val _movieDetails: MutableLiveData<MovieDetailsUi?> = MutableLiveData()
    val movieDetails: LiveData<MovieDetailsUi?> get() = _movieDetails

    private val _similarMovies: MutableLiveData<List<MovieModel>> = MutableLiveData()
    val similarMovies: LiveData<List<MovieModel>> get() = _similarMovies

    private val _recommendMovies: MutableLiveData<List<MovieModel>> = MutableLiveData()
    val recommendMovies: LiveData<List<MovieModel>> get() = _recommendMovies

    fun getData(movieId: Int) {
        viewModelScope.launch {
            kotlin.runCatching {
                useCase.getMovieDetails(movieId = movieId)
            }.onSuccess {
                _movieDetails.value = mapper.mapMovieDetails(it)
            }.onFailure {
                _movieDetails.value = null
            }
            getSimilarMovies(movieId)
            getRecommendMovies(movieId)
        }
    }

    private suspend fun getSimilarMovies(movieId: Int) {
        kotlin.runCatching {
            useCase.getSimilarMovies(movieId = movieId)
        }.onSuccess {
            _similarMovies.value = mapper.mapMovieList(it.moviesList ?: emptyList())
        }.onFailure {
            _similarMovies.value = emptyList()
        }
    }

    private suspend fun getRecommendMovies(movieId: Int) {
            kotlin.runCatching {
                useCase.getRecommendMovies(movieId = movieId)
            }.onSuccess {
                _recommendMovies.value = mapper.mapMovieList(it.moviesList ?: emptyList())
            }.onFailure {
                _recommendMovies.value = emptyList()
            }
        }
}