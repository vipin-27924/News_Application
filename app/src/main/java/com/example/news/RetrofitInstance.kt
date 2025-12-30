package com.example.news

import retrofit2.Retrofit
import kotlin.getValue
import kotlin.setValue
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: newsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(newsApi::class.java)
    }
}