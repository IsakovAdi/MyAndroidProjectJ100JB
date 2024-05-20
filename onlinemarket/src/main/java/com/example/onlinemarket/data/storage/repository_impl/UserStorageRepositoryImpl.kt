package com.example.onlinemarket.data.storage.repository_impl

import com.example.onlinemarket.data.storage.dataSource.UserStorageDataSource
import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.repository.storage.UserStorageRepository

class UserStorageRepositoryImpl(
    private val dataSource: UserStorageDataSource,
) : UserStorageRepository {
    override fun getSavedUser(): User? {
        return dataSource.getSavedUser()
    }
}