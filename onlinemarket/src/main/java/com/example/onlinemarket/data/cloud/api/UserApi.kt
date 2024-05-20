package com.example.onlinemarket.data.cloud.api

import com.example.onlinemarket.data.cloud.network.Endpoints
import com.example.onlinemarket.data.cloud.network.Utils
import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserApi {

    @POST(Endpoints.USERS)
    suspend fun register(
        @Body user: User,
        @Header("X-Parse-Revocable-Session") session: Int = 1,
        @Header("Content-Type") contentType: String = Utils.CONTENT_TYPE,
    ): Response<UserResponse>


    suspend fun login()


}