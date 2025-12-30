package com.example.news

import kotlinx.serialization.StringFormat

data class NewsResponse(
    val articles : List<HomeItem>
)

data class HomeItem(
    val id: Int?,
    val name: String?,
    val author : String?,
    val title : String?,
    val description : String?,
    val url : String?,
    val urlToImage : String?,
    val content : String?
)
