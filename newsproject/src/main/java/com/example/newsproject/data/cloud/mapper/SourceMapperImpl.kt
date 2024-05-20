package com.example.newsproject.data.cloud.mapper

import com.example.newsproject.data.cloud.entity.SourceEntity
import com.example.newsproject.domain.cloud.model.SourceData

class SourceMapperImpl : SourceMapper {
    override fun mapSource(from: SourceEntity): SourceData =
        SourceData(
            id = from.id ?: "",
            name = from.name ?: ""
        )
}