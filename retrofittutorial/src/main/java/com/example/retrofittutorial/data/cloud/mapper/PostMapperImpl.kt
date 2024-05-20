package com.example.retrofittutorial.data.cloud.mapper

import com.example.retrofittutorial.data.cloud.PostEntity
import com.example.retrofittutorial.domain.model.PostData

class PostMapperImpl : PostMapper {
    override fun mapPost(from: PostEntity): PostData {
        return PostData(
            postId = from.postId,
            userId = from.userId,
            postTitle = from.postTitle,
            description = from.description,
            name = from.name,
            email = from.email,
            commentsPostId = from.commentsPostId
        )
    }

    override fun mapPostList(from: List<PostEntity>): List<PostData> {
        return from.map { post ->
            mapPost(post)
        }
    }
}