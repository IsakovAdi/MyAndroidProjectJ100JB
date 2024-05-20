package com.example.newsproject.di

import com.example.newsproject.domain.cloud.use_cases.GetAllNewsUseCase
import com.example.newsproject.domain.cloud.use_cases.GetAllNewsUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    factory<GetAllNewsUseCase> {
        GetAllNewsUseCaseImpl(repository = get())
    }
}