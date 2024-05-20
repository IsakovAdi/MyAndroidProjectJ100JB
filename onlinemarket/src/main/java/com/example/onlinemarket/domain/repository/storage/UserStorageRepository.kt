package com.example.onlinemarket.domain.repository.storage

import com.example.onlinemarket.domain.models.User

interface UserStorageRepository {
    fun getSavedUser(): User?
}