package com.example.movieapp.data.cloud.network

import com.example.movieapp.data.cloud.api.MovieApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).addInterceptor {chain->
        val request = chain.request().newBuilder()
            .addHeader("accept", "application/json")
            .addHeader("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMjQ5ZGJhOWJhOGE4MWM1M2Y0MmExMjRmZTg5ZThlNSIsInN1YiI6IjYxODYyNjcxNzAzMDlmMDA0MzkyNDQyMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Q2AApWw3k8MBBTqkWzNWCKGK4xlquUgsc36DpIbIrRg")
        chain.proceed(request.build())
    }.build()


   private val retrofit by lazy {
        Retrofit.Builder().baseUrl(Endpoints.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val movieApi: MovieApi by lazy {
        retrofit.create(MovieApi::class.java)
    }

}