package com.example.retrofittutorial.domain.cloud.useCases

import com.example.retrofittutorial.domain.cloud.repository.CloudRepository
import com.example.retrofittutorial.domain.model.PostData

class GetAllPostsUseCaseImpl(private val repository: CloudRepository) : GetAllPostsUseCase {
    override suspend fun getPosts(): List<PostData> = repository.getPosts()
}