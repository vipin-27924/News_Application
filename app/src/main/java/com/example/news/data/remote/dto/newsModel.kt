package com.example.news.data.remote.dto

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.remote.RetrofitInstance
import com.example.news.ui.home.HomeItem
import kotlinx.coroutines.launch

// A sealed class ensures we handle every possible state
sealed class NewsUiState {
    object Loading : NewsUiState()
    data class Success(val articles: List<HomeItem>) : NewsUiState()
    data class Error(val message: String) : NewsUiState()
}

class NewsViewModel : ViewModel() {
    var uiState by mutableStateOf<NewsUiState>(NewsUiState.Loading)
        private set

    init {
        fetchnews()
    }

    private fun fetchnews() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTopHeadlines()
                if (response.articles.isEmpty()) {
                    uiState = NewsUiState.Error("No news found. Check your API or internet access.")
                } else {
                    uiState = NewsUiState.Success(response.articles)
                }
            } catch (e: Exception) {
                uiState = NewsUiState.Error("Failed to load news: ${e.localizedMessage}")
            }
        }
    }
}
