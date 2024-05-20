package com.example.onlinemarket.domain.interactors.cloud

import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.models.UserResponse

interface UserInteractors {
    suspend operator fun invoke(user: User):UserResponse?
}