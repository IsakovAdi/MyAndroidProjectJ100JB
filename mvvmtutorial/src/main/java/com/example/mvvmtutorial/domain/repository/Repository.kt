package com.example.mvvmtutorial.domain.repository

interface Repository {
    fun save(text: String)
    fun getText(): String
}