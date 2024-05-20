package com.example.retrofittutorial.data.cloud.source

import com.example.retrofittutorial.domain.model.PostData

interface CloudSourceRepository {
    suspend fun getAllPosts(order:String): List<PostData>
    suspend fun getPostById(postId:Int):PostData
    suspend fun getCommentsPostById(postId: Int):List<PostData>
    suspend fun getSortedPost(postId: Int, sortBy:String, order: String):List<PostData>
}