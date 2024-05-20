package com.example.retrofittutorial.di

import com.example.retrofittutorial.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getAllPostsUseCase = get(),
            postByIdUseCase = get(),
            commentsPostByIdUseCase = get(),
            getSortedPostsUseCaseImpl = get()
        )
    }
}