package com.example.retrofittutorial.di

import com.example.retrofittutorial.domain.cloud.useCases.GetAllPostsUseCase
import com.example.retrofittutorial.domain.cloud.useCases.GetAllPostsUseCaseImpl
import com.example.retrofittutorial.domain.cloud.useCases.GetCommentsPostByIdUseCase
import com.example.retrofittutorial.domain.cloud.useCases.GetCommentsPostByIdUseCaseImpl
import com.example.retrofittutorial.domain.cloud.useCases.GetPostByIdUseCase
import com.example.retrofittutorial.domain.cloud.useCases.GetPostByIdUseCaseImpl
import com.example.retrofittutorial.domain.cloud.useCases.GetSortedPostsUseCase
import com.example.retrofittutorial.domain.cloud.useCases.GetSortedPostsUseCaseImpl
import org.koin.dsl.module


val domainModule = module {
    factory<GetAllPostsUseCase> {
        GetAllPostsUseCaseImpl(repository = get())
    }

    factory<GetPostByIdUseCase> {
        GetPostByIdUseCaseImpl(repository = get())
    }
    factory<GetCommentsPostByIdUseCase> {
        GetCommentsPostByIdUseCaseImpl(repository = get())
    }
    factory<GetSortedPostsUseCase> {
        GetSortedPostsUseCaseImpl(repository = get())
    }
}