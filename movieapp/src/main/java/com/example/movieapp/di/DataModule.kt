package com.example.movieapp.di

import com.example.movieapp.data.cloud.MovieRepositoryImpl
import com.example.movieapp.data.cloud.mapper.MovieMapperFromEntity
import com.example.movieapp.data.cloud.mapper.MovieMapperFromEntityImpl
import com.example.movieapp.data.cloud.network.RetrofitInstance
import com.example.movieapp.data.cloud.source.MovieCloudDataSource
import com.example.movieapp.data.cloud.source.MovieCloudDataSourceImpl
import com.example.movieapp.domain.cloud.MovieCloudRepository
import org.koin.dsl.module

val dataModule = module {

    single<MovieMapperFromEntity> {
        MovieMapperFromEntityImpl()
    }

    single<MovieCloudDataSource> {
        MovieCloudDataSourceImpl(
            api = RetrofitInstance.movieApi,
            mapper = get()
        )
    }

    single<MovieCloudRepository> {
        MovieRepositoryImpl(
            cloudDataSource = get()
        )
    }
}