package com.example.newsproject.di

import com.example.newsproject.presentation.main_activity.MainActivityViewModel
import com.example.newsproject.presentation.mapper.MapToUi
import com.example.newsproject.presentation.mapper.MapToUiImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.single

val appModule = module {

    single<MapToUi> {
        MapToUiImpl()
    }

    viewModel<MainActivityViewModel> {
        MainActivityViewModel(allNewsUseCase = get(), mapper = get())
    }
}