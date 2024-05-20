package com.example.retrofittutorial.domain.cloud.useCases

import com.example.retrofittutorial.domain.cloud.repository.CloudRepository
import com.example.retrofittutorial.domain.model.PostData

class GetSortedPostsUseCaseImpl(private val repository: CloudRepository) : GetSortedPostsUseCase {
    override suspend fun getPosts(postId: Int, sortBy: String, order: String): List<PostData> =
        repository.getSortedPosts(postId, sortBy, order)
}