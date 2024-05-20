package com.example.mvvmtutorial.di

import com.example.mvvmtutorial.presentation.ui.MainActivityViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainActivityViewModel> {
        MainActivityViewModel(
            saveUseCase = get(),
            getSavedTextUseCase = get(),
            context = androidContext()
        )
    }
}