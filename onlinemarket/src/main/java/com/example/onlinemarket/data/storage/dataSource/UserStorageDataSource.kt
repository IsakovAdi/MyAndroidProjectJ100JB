package com.example.onlinemarket.data.storage.dataSource

import com.example.onlinemarket.domain.models.User

interface UserStorageDataSource {
    fun saveUser(user: User)
    fun getSavedUser(): User?

    fun removeUser()
}