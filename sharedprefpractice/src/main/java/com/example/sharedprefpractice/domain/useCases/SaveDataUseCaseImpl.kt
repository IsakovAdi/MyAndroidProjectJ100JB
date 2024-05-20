package com.example.sharedprefpractice.domain.useCases

import com.example.sharedprefpractice.domain.model.Item
import com.example.sharedprefpractice.domain.repository.Repository

class SaveDataUseCaseImpl(val repository: Repository):SaveDataUseCase {
    override fun saveData(data: List<Item>) {
        repository.saveData(data)
    }
}