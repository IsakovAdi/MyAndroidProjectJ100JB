package com.example.newsproject.data.cloud.mapper

import com.example.newsproject.data.cloud.entity.NewsResponseEntity
import com.example.newsproject.domain.cloud.model.NewsResponse

class NewsResponseMapperImpl(private val newsMapper: NewsMapper) : NewsResponseMapper {
    override fun map(responseEntity: NewsResponseEntity): NewsResponse {
        return NewsResponse(
            status = responseEntity.status ?: "",
            totalResults = responseEntity.totalResults ?: 0,
            articles = newsMapper.mapArticles(responseEntity.articles ?: emptyList())
        )
    }
}