package com.example.sharedprefpractice.domain.useCases

import com.example.sharedprefpractice.domain.model.Item

interface GetDataUseCase {
    fun getData():List<Item>
}