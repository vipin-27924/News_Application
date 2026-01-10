package com.example.news.ui.trending

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.remote.RetrofitInstance
import com.example.news.data.remote.dto.NewsUiState
import kotlinx.coroutines.launch

class TrendingViewModel : ViewModel() {

    // We can reuse the existing NewsUiState sealed class!
    var uiState by mutableStateOf<NewsUiState>(NewsUiState.Loading)
        private set

    init {
        fetchTrendingNews()
    }

    private fun fetchTrendingNews() {
        viewModelScope.launch {
            try {
                // Usage of 'getEverything' allows searching for specific topics
                // You can change "trending" to "technology", "crypto", "sports", etc.
                val response = RetrofitInstance.api.getEverything(query = "trending")

                if (response.articles.isEmpty()) {
                    uiState = NewsUiState.Error("No trending news found.")
                } else {
                    uiState = NewsUiState.Success(response.articles)
                }
            } catch (e: Exception) {
                uiState = NewsUiState.Error("Failed to load trending news: ${e.localizedMessage}")
            }
        }
    }
}