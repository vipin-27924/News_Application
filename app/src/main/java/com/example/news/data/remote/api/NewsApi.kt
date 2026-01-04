package com.example.news.data.remote.api

import com.example.news.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getTopHeadlines(
        @Query("q") country: String = "indian-politics",
        @Query("apiKey") apiKey: String = "98d74edcbd5e420994f9b53aaee658fa"
    ): NewsResponse

    @GET("everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = "98d74edcbd5e420994f9b53aaee658fa"
        ): NewsResponse
}


