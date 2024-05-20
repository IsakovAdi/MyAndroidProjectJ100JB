package com.example.newsproject.domain.cloud.model

data class NewsData(
    val source: SourceData,
    val author: String,
    val title: String,
    val description: String,
    val newsUrl: String,
    val newsPosterImageUrl: String,
    val publishedDate: String,
    val content: String,
)