package com.example.retrofittutorial.data.cloud

import com.google.gson.annotations.SerializedName

class PostEntity(
    @SerializedName("userId") val userId: Int? = null,
    @SerializedName("id") val postId: Int? = null,
    @SerializedName("title") val postTitle: String? = null,
    @SerializedName("body") val description: String? = null,
    @SerializedName("email") val email:String?=null,
    @SerializedName("name") val name:String? = null,
    @SerializedName("postId") val commentsPostId: Int? = null
)