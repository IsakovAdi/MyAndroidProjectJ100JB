package com.example.newsproject.data.cloud.entity

import com.google.gson.annotations.SerializedName

class NewsResponseEntity(
    @SerializedName("status") val status: String? = null,
    @SerializedName("totalResults") val totalResults: Int? = null,
    @SerializedName("articles") val articles: List<NewsEntity>? = null,
) {
}