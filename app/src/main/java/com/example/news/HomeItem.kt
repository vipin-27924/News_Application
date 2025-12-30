package com.example.news

import kotlinx.serialization.StringFormat

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<HomeItem>
)

data class HomeItem(
    val source: Source?,       // MUST BE NESTED
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)

data class Source(
    val id: String?,           // MUST BE A STRING, NOT AN INT
    val name: String?
)