package com.example.newsproject.domain.cloud.use_cases

import com.example.newsproject.domain.cloud.model.NewsResponse

interface GetAllNewsUseCase {
    suspend operator fun invoke(params: HashMap<String, String> = HashMap()): NewsResponse
}