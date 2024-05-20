package com.example.retrofittutorial.domain.cloud.useCases

import com.example.retrofittutorial.domain.cloud.repository.CloudRepository
import com.example.retrofittutorial.domain.model.PostData

class GetPostByIdUseCaseImpl(private val repository: CloudRepository) : GetPostByIdUseCase {
    override suspend fun getPostById(postId: Int): PostData =
        repository.getPostById(postId = postId)
}