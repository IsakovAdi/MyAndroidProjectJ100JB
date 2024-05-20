package com.example.newsproject.data.cloud.network

import com.example.newsproject.data.cloud.entity.NewsResponseEntity
import com.example.newsproject.domain.cloud.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NewsApi {
    @GET(Endpoints.ALL_NEWS)
    suspend fun getAllNews(
        @QueryMap params: HashMap<String, String>,
    ):NewsResponseEntity
}