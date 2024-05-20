package com.example.onlinemarket.domain.models

import com.google.gson.annotations.SerializedName

class Image(
    @SerializedName("__type") val type: String = "File",
    @SerializedName("name") val name: String,
    @SerializedName("url") val imageUrl: String,
)