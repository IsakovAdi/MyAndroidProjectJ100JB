package com.example.newsproject.presentation.mapper

import com.example.newsproject.domain.cloud.model.NewsData
import com.example.newsproject.domain.cloud.model.NewsResponse
import com.example.newsproject.domain.cloud.model.SourceData
import com.example.newsproject.presentation.ui.NewsResponseUi
import com.example.newsproject.presentation.ui.NewsUi
import com.example.newsproject.presentation.ui.SourceUi

interface MapToUi {
    fun mapSourceToUi(from: SourceData): SourceUi

    fun mapArticleToUi(from: NewsData): NewsUi

    fun mapArticlesToUi(from: List<NewsData>): List<NewsUi>

    fun mapNewsResponseToUi(from: NewsResponse): NewsResponseUi
}