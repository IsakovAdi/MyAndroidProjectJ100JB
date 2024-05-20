package com.example.retrofittutorial.domain.model

data class PostData(
    val userId: Int? = null,
    val postId: Int? = null,
    val postTitle: String? = null,
    val description: String? = null,
    val email: String? = null,
    val name: String? = null,
    val commentsPostId: Int? = null,
)