package com.example.news

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class NewsViewModel : ViewModel(){

    var newsList by
    mutableStateOf(emptyList<HomeItem>())

    private set
    var loading by mutableStateOf(true)
    private set
     init {
         fetchnews()
     }

    private fun fetchnews() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTopHeadlines()
                newsList = response.articles
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}