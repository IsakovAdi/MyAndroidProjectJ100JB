package com.example.mvvmtutorial.data.storage

interface StorageRepository {
    fun save(text: String)
    fun getText(): String
}