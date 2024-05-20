package com.example.newsproject.data.cloud.mapper

import com.example.newsproject.data.cloud.entity.NewsEntity
import com.example.newsproject.data.cloud.entity.SourceEntity
import com.example.newsproject.domain.cloud.model.NewsData
import com.example.newsproject.domain.cloud.model.SourceData

class NewsMapperImpl(private val sourceMapper: SourceMapper) : NewsMapper {
    override fun mapArticle(from: NewsEntity): NewsData {
        return NewsData(
            source = sourceMapper.mapSource(from.source ?: SourceEntity()),
            author = from.author ?: "",
            title = from.title ?: "",
            description = from.description ?: "",
            newsUrl = from.newsUrl ?: "",
            newsPosterImageUrl = from.newsPosterImageUrl ?: "",
            publishedDate = from.publishedDate ?: "",
            content = from.content ?: ""
        )
    }

    override fun mapArticles(from: List<NewsEntity>): List<NewsData> {
        return from.map {
            mapArticle(it)
        }
    }


}