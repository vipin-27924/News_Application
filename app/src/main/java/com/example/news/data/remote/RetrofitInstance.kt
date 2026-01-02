package com.example.news.data.remote

import com.example.news.data.remote.api.newsApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("User-Agent", "NewsApplication/1.0")
                .build()
            chain.proceed(request)
        }
        .build()

    val api: newsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(newsApi::class.java)
    }
}