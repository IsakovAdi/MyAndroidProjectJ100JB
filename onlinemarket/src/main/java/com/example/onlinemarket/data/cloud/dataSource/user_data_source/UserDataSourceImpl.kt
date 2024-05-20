package com.example.onlinemarket.data.cloud.dataSource.user_data_source

import com.example.onlinemarket.data.cloud.api.UserApi
import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.models.UserResponse
import retrofit2.Response

class UserDataSourceImpl(private val api: UserApi) : UserDataSource {
    override suspend fun register(user: User): Response<UserResponse> = api.register(user)
    override suspend fun login(login: String, password: String) {
        TODO("Not yet implemented")
    }
}