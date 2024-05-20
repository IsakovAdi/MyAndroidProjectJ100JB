package com.example.onlinemarket.domain.interactors.storage

import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.repository.storage.UserStorageRepository

class UserStorageInteractorImpl(val repository: UserStorageRepository) : UserStorageInteractor {
    override fun getSavedUser(): User? {
        return repository.getSavedUser()
    }
}