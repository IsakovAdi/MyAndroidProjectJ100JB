package com.example.newsproject.data.cloud.mapper

import com.example.newsproject.data.cloud.entity.SourceEntity
import com.example.newsproject.domain.cloud.model.SourceData

interface SourceMapper {
    fun mapSource(from:SourceEntity):SourceData
}