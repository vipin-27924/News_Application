package com.example.news.data.remote.api

import com.example.news.ui.home.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface newsApi {
    @GET("everything")
    suspend fun getTopHeadlines(
        @Query("q") category: String,
        @Query("q") country: String = "indian-politics",
        @Query("apiKey") apiKey: String = "98d74edcbd5e420994f9b53aaee658fa"
    ): NewsResponse
}


