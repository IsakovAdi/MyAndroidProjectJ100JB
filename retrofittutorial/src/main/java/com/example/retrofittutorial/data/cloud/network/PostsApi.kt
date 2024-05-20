package com.example.retrofittutorial.data.cloud.network

import com.example.retrofittutorial.data.cloud.PostEntity
import com.example.retrofittutorial.data.cloud.retrofit.Endpoints
import com.example.retrofittutorial.domain.model.PostData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface PostsApi {
//
//    @GET(Endpoints.ALL_POSTS)
//    suspend fun getPosts(): List<PostEntity>

        @GET("comments")
    suspend fun getPosts(
        @Query("postId") postId: Int,
        @Query("_sort") sortBy:String,
        @Query("_order") order:String
    ): List<PostEntity>



    @GET("comments")
    suspend fun getPosts(
        @QueryMap params: HashMap<String, String>,
    ): List<PostEntity>


    @GET("posts/{id}")
    suspend fun getPostById(
        @Path("id") postId: Int,
    ): PostEntity

    @GET("posts/{postId}/comments")
    suspend fun getCommentsPostById(
        @Path("postId") postId:Int
    ):List<PostEntity>

}