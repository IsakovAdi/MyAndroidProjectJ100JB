package com.example.sharedprefpractice.domain.useCases

import com.example.sharedprefpractice.domain.model.Item
import com.example.sharedprefpractice.domain.repository.Repository

class GetDataUseCaseImpl(val repository: Repository) : GetDataUseCase {
    override fun getData(): List<Item> {
        return repository.getData()
    }
}