package com.example.sharedprefpractice.domain.useCases

import com.example.sharedprefpractice.domain.model.Item

interface SaveDataUseCase {
    fun saveData(data:List<Item>)
}