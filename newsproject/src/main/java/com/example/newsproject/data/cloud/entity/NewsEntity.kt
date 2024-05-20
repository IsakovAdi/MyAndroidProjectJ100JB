package com.example.newsproject.data.cloud.entity

import com.google.gson.annotations.SerializedName

class NewsEntity(
    @SerializedName("source") val source: SourceEntity? = null,
    @SerializedName("author") val author: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("url") val newsUrl: String? = null,
    @SerializedName("urlToImage") val newsPosterImageUrl: String? = null,
    @SerializedName("publishedAt") val publishedDate: String? = null,
    @SerializedName("content") val content: String? = null,
) {
}