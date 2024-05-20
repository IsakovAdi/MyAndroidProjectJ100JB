package com.example.sharedprefpractice.domain.repository

import com.example.sharedprefpractice.domain.model.Item

interface Repository {
    fun saveData(data: List<Item>)

    fun getData(): List<Item>

}