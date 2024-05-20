package com.example.retrofittutorial.data.cloud.retrofit

import com.example.retrofittutorial.data.cloud.network.PostsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {

    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()


    val retrofit by lazy {
        Retrofit.Builder().baseUrl(Endpoints.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val postsApi: PostsApi by lazy {
        retrofit.create(PostsApi::class.java)
    }

}