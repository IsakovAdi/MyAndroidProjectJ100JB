package com.example.newsproject.domain.cloud.repository

import com.example.newsproject.domain.cloud.model.NewsResponse

interface NewsRepository {
    suspend fun getAllNews(params: HashMap<String, String>): NewsResponse
}