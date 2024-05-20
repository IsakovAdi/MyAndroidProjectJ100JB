package com.example.retrofittutorial.data.cloud.mapper

import com.example.retrofittutorial.data.cloud.PostEntity
import com.example.retrofittutorial.domain.model.PostData

interface PostMapper {
    fun mapPost(from:PostEntity):PostData
    fun mapPostList(from:List<PostEntity>):List<PostData>
}