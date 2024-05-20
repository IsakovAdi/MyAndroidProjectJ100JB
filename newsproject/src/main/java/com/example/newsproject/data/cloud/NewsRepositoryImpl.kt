package com.example.newsproject.data.cloud

import com.example.newsproject.data.cloud.source.NewsCloudDataSource
import com.example.newsproject.domain.cloud.model.NewsResponse
import com.example.newsproject.domain.cloud.repository.NewsRepository

class NewsRepositoryImpl(private val cloudSource: NewsCloudDataSource) : NewsRepository {
    override suspend fun getAllNews(params: HashMap<String, String>): NewsResponse {
        return cloudSource.getAllNews(params = params)
    }
}