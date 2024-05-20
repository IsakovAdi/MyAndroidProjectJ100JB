package com.example.retrofittutorial.domain.cloud.useCases

import com.example.retrofittutorial.domain.model.PostData

interface GetCommentsPostByIdUseCase {
    suspend fun getPosts(postId:Int):List<PostData>
}