package com.example.onlinemarket.di

import com.example.onlinemarket.domain.interactors.cloud.UserInteractors
import com.example.onlinemarket.domain.interactors.cloud.UserInteractorsImpl
import com.example.onlinemarket.domain.interactors.storage.UserStorageInteractor
import com.example.onlinemarket.domain.interactors.storage.UserStorageInteractorImpl
import org.koin.dsl.module

val domainModule = module {

    factory<UserInteractors> {
        UserInteractorsImpl(get())
    }

    factory<UserStorageInteractor> {
        UserStorageInteractorImpl(repository = get())
    }
}