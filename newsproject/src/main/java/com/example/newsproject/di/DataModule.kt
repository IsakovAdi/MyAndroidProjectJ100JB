package com.example.newsproject.di

import com.example.newsproject.data.cloud.NewsRepositoryImpl
import com.example.newsproject.data.cloud.mapper.NewsMapper
import com.example.newsproject.data.cloud.mapper.NewsMapperImpl
import com.example.newsproject.data.cloud.mapper.NewsResponseMapper
import com.example.newsproject.data.cloud.mapper.NewsResponseMapperImpl
import com.example.newsproject.data.cloud.mapper.SourceMapper
import com.example.newsproject.data.cloud.mapper.SourceMapperImpl
import com.example.newsproject.data.cloud.network.RetrofitInstance
import com.example.newsproject.data.cloud.source.NewsCloudDataSource
import com.example.newsproject.data.cloud.source.NewsCloudDataSourceImpl
import com.example.newsproject.domain.cloud.repository.NewsRepository
import org.koin.dsl.module
import org.koin.dsl.single


val dataModule = module {

    single<SourceMapper> {
        SourceMapperImpl()
    }

    single<NewsMapper> {
        NewsMapperImpl(sourceMapper = get())
    }

    single<NewsResponseMapper> {
        NewsResponseMapperImpl(newsMapper = get())
    }

    single<NewsCloudDataSource> {
        NewsCloudDataSourceImpl(api = RetrofitInstance.newsApi, mapResponse = get())
    }
    single<NewsRepository> {
        NewsRepositoryImpl(cloudSource = get())
    }
}