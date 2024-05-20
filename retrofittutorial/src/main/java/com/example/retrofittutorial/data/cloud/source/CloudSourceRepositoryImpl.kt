package com.example.retrofittutorial.data.cloud.source

import com.example.retrofittutorial.data.cloud.mapper.PostMapper
import com.example.retrofittutorial.data.cloud.network.PostsApi
import com.example.retrofittutorial.data.cloud.retrofit.MyRetrofit
import com.example.retrofittutorial.domain.model.PostData

class CloudSourceRepositoryImpl(
    private val mapper: PostMapper,
    private val api: PostsApi
) : CloudSourceRepository {
    override suspend fun getAllPosts(order: String): List<PostData> {
        return mapper.mapPostList(api.getPosts(5, "id", ""))
    }

    override suspend fun getPostById(postId: Int): PostData {
        return mapper.mapPost(api.getPostById(postId))
    }

    override suspend fun getCommentsPostById(postId: Int): List<PostData> {
        return mapper.mapPostList(api.getCommentsPostById(postId))
    }

    override suspend fun getSortedPost(postId: Int, sortBy: String, order: String): List<PostData> {
        val params = HashMap<String, String>()
        params.put("postId", postId.toString())
        params.put("_sort", sortBy)
        if (order.isNotEmpty()) {
            params.put("_order", order)
        }
        return mapper.mapPostList(api.getPosts(params))
    }

}