package com.example.onlinemarket.domain.models

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("objectId") var objectId: String? = null,
    @SerializedName("full_name") val userName: String? = null,
    @SerializedName("username") val login: String? = null,
    @SerializedName("password") val password: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("user_avatar") val userImage: Image? = null,
)