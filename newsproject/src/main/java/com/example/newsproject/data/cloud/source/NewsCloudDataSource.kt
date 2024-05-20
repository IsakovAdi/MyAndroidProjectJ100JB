package com.example.newsproject.data.cloud.source

import com.example.newsproject.domain.cloud.model.NewsResponse

interface NewsCloudDataSource {
   suspend fun getAllNews(params: HashMap<String, String>): NewsResponse
}