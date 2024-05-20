package com.example.newsproject.presentation.mapper

import com.example.newsproject.domain.cloud.model.NewsData
import com.example.newsproject.domain.cloud.model.NewsResponse
import com.example.newsproject.domain.cloud.model.SourceData
import com.example.newsproject.presentation.ui.NewsResponseUi
import com.example.newsproject.presentation.ui.NewsUi
import com.example.newsproject.presentation.ui.SourceUi

class MapToUiImpl : MapToUi {
    override fun mapSourceToUi(from: SourceData): SourceUi =
        SourceUi(
            id = from.id,
            name = from.name
        )

    override fun mapArticleToUi(from: NewsData): NewsUi =
        NewsUi(
            source = mapSourceToUi(from.source),
            author = from.author,
            title = from.title,
            description = from.description,
            newsUrl = from.newsUrl,
            newsPosterImageUrl = from.newsPosterImageUrl,
            publishedDate = from.publishedDate,
            content = from.content
        )

    override fun mapArticlesToUi(from: List<NewsData>): List<NewsUi> {
        return from.map { mapArticleToUi(it) }
    }

    override fun mapNewsResponseToUi(from: NewsResponse): NewsResponseUi {
        return NewsResponseUi(
            status = from.status,
            totalResults = from.totalResults,
            articles = mapArticlesToUi(from.articles)
        )
    }
}