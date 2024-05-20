package com.example.retrofittutorial.domain.cloud.repository

import com.example.retrofittutorial.domain.model.PostData

interface CloudRepository {
    suspend fun getPosts(): List<PostData>

    suspend fun getPostById(postId:Int):PostData
    suspend fun getCommentsPostById(postId: Int):List<PostData>
    suspend fun getSortedPosts(postId: Int, sortBy:String, order:String):List<PostData>
}