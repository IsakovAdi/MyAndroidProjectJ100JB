package com.example.onlinemarket.domain.interactors.storage

import com.example.onlinemarket.domain.models.User

interface UserStorageInteractor {
    fun getSavedUser(): User?
}