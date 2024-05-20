package com.example.mvvmtutorial.data

import com.example.mvvmtutorial.data.storage.StorageRepository
import com.example.mvvmtutorial.domain.repository.Repository

class RepositoryImpl(private val storageRepository: StorageRepository) : Repository {
    override fun save(text: String) {
        storageRepository.save(text)
    }

    override fun getText(): String =
        storageRepository.getText()
}