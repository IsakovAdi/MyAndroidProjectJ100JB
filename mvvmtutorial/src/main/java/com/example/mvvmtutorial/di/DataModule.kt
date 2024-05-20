package com.example.mvvmtutorial.di

import com.example.mvvmtutorial.data.RepositoryImpl
import com.example.mvvmtutorial.data.storage.StorageRepository
import com.example.mvvmtutorial.data.storage.StorageRepositoryImpl
import com.example.mvvmtutorial.domain.repository.Repository
import com.example.mvvmtutorial.presentation.ui.MainActivity
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val dataModule = module {
    single<StorageRepository> {
        StorageRepositoryImpl(context = androidContext())
    }

    single<Repository> {
        RepositoryImpl(storageRepository = get())
    }
}