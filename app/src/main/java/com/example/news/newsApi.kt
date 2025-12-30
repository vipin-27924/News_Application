package com.example.news

import retrofit2.http.GET
import retrofit2.http.Query

interface newsApi {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "in",
        @Query("apiKey") apiKey: String = "98d74edcbd5e420994f9b53aaee658fa"
    ): NewsResponse
}