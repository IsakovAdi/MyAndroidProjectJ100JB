package com.example.newsproject.data.cloud.entity

import com.google.gson.annotations.SerializedName

class SourceEntity(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
)