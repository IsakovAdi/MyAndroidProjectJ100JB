package com.example.retrofittutorial.domain.cloud.useCases

import com.example.retrofittutorial.domain.cloud.repository.CloudRepository
import com.example.retrofittutorial.domain.model.PostData

class GetCommentsPostByIdUseCaseImpl(private val repository: CloudRepository):GetCommentsPostByIdUseCase {
    override suspend fun getPosts(postId: Int): List<PostData> = repository.getCommentsPostById(postId)
}