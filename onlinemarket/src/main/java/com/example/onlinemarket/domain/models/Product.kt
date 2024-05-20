package com.example.onlinemarket.domain.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("objectId") val productId: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("price") val productPrice: String,
    @SerializedName("title") val productTitle: String,
    @SerializedName("description") val productDesc: String,
    @SerializedName("product_image") val productImage: Image,
    @SerializedName("owner_id") val ownerId: String,
)