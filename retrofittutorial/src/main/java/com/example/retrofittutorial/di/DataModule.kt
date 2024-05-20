package com.example.retrofittutorial.di

import com.example.retrofittutorial.data.cloud.CloudRepositoryImpl
import com.example.retrofittutorial.data.cloud.mapper.PostMapper
import com.example.retrofittutorial.data.cloud.mapper.PostMapperImpl
import com.example.retrofittutorial.data.cloud.retrofit.MyRetrofit
import com.example.retrofittutorial.data.cloud.source.CloudSourceRepository
import com.example.retrofittutorial.data.cloud.source.CloudSourceRepositoryImpl
import com.example.retrofittutorial.domain.cloud.repository.CloudRepository
import org.koin.dsl.module


val dataModule = module {
    single<CloudSourceRepository> {
        CloudSourceRepositoryImpl(mapper = get(), api = MyRetrofit.postsApi)
    }

    single<CloudRepository> {
        CloudRepositoryImpl(cloudSource = get())
    }
    single<PostMapper> {
        PostMapperImpl()
    }
}