package com.example.newsproject.data.cloud.mapper

import com.example.newsproject.data.cloud.entity.NewsEntity
import com.example.newsproject.domain.cloud.model.NewsData

interface NewsMapper {
    fun mapArticle(from:NewsEntity):NewsData
    fun mapArticles(from: List<NewsEntity>):List<NewsData>
}