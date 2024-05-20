package com.example.newsproject.data.cloud.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()


    val retrofit by lazy {
        Retrofit.Builder().baseUrl(Endpoints.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsApi: NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }

}