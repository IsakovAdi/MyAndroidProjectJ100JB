package com.example.onlinemarket.di

import com.example.onlinemarket.presentation.fragments.login_fragment.LoginFragmentViewModel
import com.example.onlinemarket.presentation.fragments.register_fragment.RegisterFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<RegisterFragmentViewModel> {
        RegisterFragmentViewModel(get())
    }

    viewModel<LoginFragmentViewModel> {
        LoginFragmentViewModel(get())
    }
}