package com.example.movieapp.presentation.ui.fragments.home_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.cloud.network.RetrofitInstance
import com.example.movieapp.domain.cloud.interactors.GetMoviesUseCase
import com.example.movieapp.presentation.mapper.MapMovieFromDomain
import com.example.movieapp.presentation.model.MovieModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

enum class MovieType {
    POPULAR,
    NOW_PLAYING,
    TOP_RATED,
    UPCOMING
}

class HomeFragmentViewModel(
    private val useCase: GetMoviesUseCase,
    private val mapper: MapMovieFromDomain,
) : ViewModel() {

    private val _movies: MutableLiveData<List<MovieModel>> = MutableLiveData()
    val movies: LiveData<List<MovieModel>> get() = _movies
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    private val _currentPage: MutableLiveData<Int> = MutableLiveData(DEFAULT_PAGE_VALUE)
    val currentPage: LiveData<Int> get() = _currentPage

    private var _totalPages = DEFAULT_PAGE_VALUE
    private var type: MovieType = MovieType.POPULAR

    fun getMovie(moviesType: MovieType = MovieType.POPULAR) {
        if (moviesType != type) {
            type = moviesType
            _currentPage.value = DEFAULT_PAGE_VALUE
        }
        when (moviesType) {
            MovieType.POPULAR -> getPopularMovies()
            MovieType.NOW_PLAYING -> getNowPlayingMovies()
            MovieType.TOP_RATED -> getTopRatedMovies()
            MovieType.UPCOMING -> getUpcomingMovies()
        }
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            kotlin.runCatching {
                useCase.getPopularMovies("ru", _currentPage.value?: DEFAULT_PAGE_VALUE)
            }.onSuccess {
                it.moviesList?.let { movies ->
                    _movies.value = mapper.mapMovieList(movies)
                }
                _totalPages = it.totalPages ?: DEFAULT_PAGE_VALUE
            }.onFailure {
                errorMessage.value = "Что то пошло не так"
            }
        }
    }

    private fun getNowPlayingMovies() {
        viewModelScope.launch {
            kotlin.runCatching {
                useCase.getNowPlayingMovies("ru", _currentPage.value?: DEFAULT_PAGE_VALUE)
            }.onSuccess {
                it.moviesList?.let { movies ->
                    _movies.value = mapper.mapMovieList(movies)
                }
                _totalPages = it.totalPages ?: DEFAULT_PAGE_VALUE
            }.onFailure {
                errorMessage.value = "Что то пошло не так"
            }
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            kotlin.runCatching {
                useCase.getTopRatedMovies("ru", _currentPage.value?: DEFAULT_PAGE_VALUE)
            }.onSuccess {
                it.moviesList?.let { movies ->
                    _movies.value = mapper.mapMovieList(movies)
                }
                _totalPages = it.totalPages ?: DEFAULT_PAGE_VALUE
            }.onFailure {
                errorMessage.value = "Что то пошло не так"
            }
        }
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            kotlin.runCatching {
                useCase.getUpcomingMovies("ru", _currentPage.value?: DEFAULT_PAGE_VALUE)
            }.onSuccess {
                it.moviesList?.let { movies ->
                    _movies.value = mapper.mapMovieList(movies)
                }
                _totalPages = it.totalPages ?: DEFAULT_PAGE_VALUE
            }.onFailure {
                errorMessage.value = "Что то пошло не так"
            }
        }
    }

    fun nextPage() {
        var page = _currentPage.value?: DEFAULT_PAGE_VALUE
        if (page < _totalPages) {
            page++
            _currentPage.value = page
            getMovie(type)
        }
    }

    fun previousPage() {
        var page = _currentPage.value?: DEFAULT_PAGE_VALUE
        if (page > DEFAULT_PAGE_VALUE) {
            page--
            _currentPage.value = page
            getMovie(type)
        }
    }


    companion object {
        const val DEFAULT_PAGE_VALUE = 1
    }
}