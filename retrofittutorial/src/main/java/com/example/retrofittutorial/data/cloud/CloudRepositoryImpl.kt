package com.example.retrofittutorial.data.cloud

import com.example.retrofittutorial.data.cloud.source.CloudSourceRepository
import com.example.retrofittutorial.domain.cloud.repository.CloudRepository
import com.example.retrofittutorial.domain.model.PostData

class CloudRepositoryImpl(private val cloudSource: CloudSourceRepository) : CloudRepository {
    override suspend fun getPosts(): List<PostData> = cloudSource.getAllPosts("")
    override suspend fun getPostById(postId: Int): PostData {
        return cloudSource.getPostById(postId = postId)
    }

    override suspend fun getCommentsPostById(postId: Int): List<PostData> {
        return cloudSource.getCommentsPostById(postId)
    }

    override suspend fun getSortedPosts(
        postId: Int,
        sortBy: String,
        order: String,
    ): List<PostData> {
        return cloudSource.getSortedPost(postId, sortBy, order)
    }
}