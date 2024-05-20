package com.example.mvvmtutorial.di

import com.example.mvvmtutorial.domain.useCases.GetTextUseCase
import com.example.mvvmtutorial.domain.useCases.GetTextUseCaseImpl
import com.example.mvvmtutorial.domain.useCases.SaveTextUseCase
import com.example.mvvmtutorial.domain.useCases.SaveTextUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetTextUseCase> {
        GetTextUseCaseImpl(repository = get())
    }

    factory<SaveTextUseCase> {
        SaveTextUseCaseImpl(repository = get())
    }
}