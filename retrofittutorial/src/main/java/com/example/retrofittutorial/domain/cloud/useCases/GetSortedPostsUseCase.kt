package com.example.retrofittutorial.domain.cloud.useCases

import com.example.retrofittutorial.domain.model.PostData

interface GetSortedPostsUseCase {
    suspend fun getPosts(postId:Int, sortBy:String, order:String):List<PostData>
}