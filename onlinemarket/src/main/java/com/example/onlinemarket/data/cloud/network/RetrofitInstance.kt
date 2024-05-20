package com.example.onlinemarket.data.cloud.network

import com.example.onlinemarket.data.cloud.api.UserApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    val requestInterceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Parse-Application-Id", Utils.APP_ID)
            .addHeader("X-Parse-REST-API-Key", Utils.API_KEY)
            .build()
        return@Interceptor chain.proceed(request)
    }

    private val loggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(Utils.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userApi: UserApi = retrofit.create(UserApi::class.java)
}