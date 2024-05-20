package com.example.newsproject.data.cloud.source

import com.example.newsproject.data.cloud.mapper.NewsResponseMapper
import com.example.newsproject.data.cloud.network.Endpoints
import com.example.newsproject.data.cloud.network.NewsApi
import com.example.newsproject.domain.cloud.model.NewsResponse

class NewsCloudDataSourceImpl(
    val api: NewsApi,
    private val mapResponse: NewsResponseMapper,
) : NewsCloudDataSource {
    override suspend fun getAllNews(params: HashMap<String, String>): NewsResponse {
        params.put("apiKey", Endpoints.API_KEY)
        params.put("domains", Endpoints.DOMAINS)
        return mapResponse.map(api.getAllNews(params = params))
    }
}