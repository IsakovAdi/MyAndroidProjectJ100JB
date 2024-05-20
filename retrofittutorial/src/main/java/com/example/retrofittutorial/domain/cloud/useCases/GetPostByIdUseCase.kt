package com.example.retrofittutorial.domain.cloud.useCases

import com.example.retrofittutorial.domain.model.PostData

interface GetPostByIdUseCase {
    suspend fun getPostById(postId: Int): PostData
}