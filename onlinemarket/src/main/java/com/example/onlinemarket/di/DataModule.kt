package com.example.onlinemarket.di

import com.example.onlinemarket.data.cloud.dataSource.user_data_source.UserDataSource
import com.example.onlinemarket.data.cloud.dataSource.user_data_source.UserDataSourceImpl
import com.example.onlinemarket.data.cloud.network.RetrofitInstance
import com.example.onlinemarket.data.cloud.repository_impl.UserRepositoryImpl
import com.example.onlinemarket.data.storage.dataSource.UserStorageDataSource
import com.example.onlinemarket.data.storage.dataSource.UserStorageDataSourceImpl
import com.example.onlinemarket.data.storage.repository_impl.UserStorageRepositoryImpl
import com.example.onlinemarket.domain.repository.UserRepository
import com.example.onlinemarket.domain.repository.storage.UserStorageRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserDataSource> {
        UserDataSourceImpl(RetrofitInstance.userApi)
    }

    single<UserStorageDataSource> {
        UserStorageDataSourceImpl(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(
            userDataSource = get(),
            userStorageDataSource = get()
        )
    }

    single<UserStorageRepository> {
        UserStorageRepositoryImpl(dataSource = get())
    }
}