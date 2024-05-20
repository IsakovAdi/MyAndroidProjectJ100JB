package com.example.onlinemarket.data.cloud.dataSource.user_data_source

import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.models.UserResponse
import retrofit2.Response

interface UserDataSource {
    suspend fun register(user: User): Response<UserResponse>

    suspend fun login(login:String, password:String)
}