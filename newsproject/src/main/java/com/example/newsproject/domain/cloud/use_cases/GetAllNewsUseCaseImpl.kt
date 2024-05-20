package com.example.newsproject.domain.cloud.use_cases

import com.example.newsproject.domain.cloud.model.NewsResponse
import com.example.newsproject.domain.cloud.repository.NewsRepository

class GetAllNewsUseCaseImpl(private val repository: NewsRepository) : GetAllNewsUseCase {
    override suspend fun invoke(params: HashMap<String, String>): NewsResponse {
        return repository.getAllNews(params = params)
    }
}