package com.example.retrofittutorial.domain.cloud.useCases

import com.example.retrofittutorial.domain.model.PostData

interface GetAllPostsUseCase {
    suspend fun getPosts():List<PostData>
}