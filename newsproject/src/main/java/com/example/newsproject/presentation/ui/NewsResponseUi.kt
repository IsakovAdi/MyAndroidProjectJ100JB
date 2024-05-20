package com.example.newsproject.presentation.ui


class NewsResponseUi(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsUi>,
)