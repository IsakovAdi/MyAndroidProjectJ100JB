package com.example.onlinemarket.domain.repository

import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.models.UserResponse

interface UserRepository {
   suspend fun register(user: User): UserResponse?
}