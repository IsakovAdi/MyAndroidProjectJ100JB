package com.example.movieapp.di

import com.example.movieapp.domain.cloud.interactors.GetMoviesUseCase
import com.example.movieapp.domain.cloud.interactors.GetMoviesUseCaseImpl
import org.koin.dsl.module


val domainModule = module {
    factory<GetMoviesUseCase> {
        GetMoviesUseCaseImpl(repository = get())
    }
}