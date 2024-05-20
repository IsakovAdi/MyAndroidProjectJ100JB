package com.example.newsproject.data.cloud.mapper

import com.example.newsproject.data.cloud.entity.NewsResponseEntity
import com.example.newsproject.domain.cloud.model.NewsResponse

interface NewsResponseMapper {
    fun map(responseEntity: NewsResponseEntity): NewsResponse
}