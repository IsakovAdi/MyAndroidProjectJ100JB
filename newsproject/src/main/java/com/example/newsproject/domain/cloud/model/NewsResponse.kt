package com.example.newsproject.domain.cloud.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsData>,
)