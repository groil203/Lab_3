package com.example.lab_3.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client = OkHttpClient.Builder().addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-RapidAPI-Key", "b130a9c3a3mshf7c1e1ea4352cf3p182ac8jsn5efefae2ba16")
            .addHeader("X-RapidAPI-Host", "exercisedb.p.rapidapi.com")
            .build()
        chain.proceed(request)
    }.build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://exercisedb.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}