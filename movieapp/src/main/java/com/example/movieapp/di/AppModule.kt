package com.example.movieapp.di

import com.example.movieapp.presentation.mapper.MapMovieFromDomain
import com.example.movieapp.presentation.mapper.MapMovieFromDomainImpl
import com.example.movieapp.presentation.ui.fragments.home_fragment.HomeFragmentViewModel
import com.example.movieapp.presentation.ui.fragments.movie_details.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<MapMovieFromDomain> {
        MapMovieFromDomainImpl()
    }
    viewModel<HomeFragmentViewModel> {
        HomeFragmentViewModel(
            useCase = get(),
            mapper = get()
        )
    }

    viewModel<MovieDetailsViewModel> {
        MovieDetailsViewModel(useCase = get(), mapper = get())
    }
}