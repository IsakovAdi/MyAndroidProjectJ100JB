package com.example.onlinemarket.domain.interactors.cloud

import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.models.UserResponse
import com.example.onlinemarket.domain.repository.UserRepository

class UserInteractorsImpl(private val repository: UserRepository) : UserInteractors {
    override suspend operator fun invoke(user: User): UserResponse? = repository.register(user)

}