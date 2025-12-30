package com.example.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NewsHomeScreen(viewModel: NewsViewModel = viewModel()) {
    val state = viewModel.uiState

    when (state) {
        is NewsUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is NewsUiState.Success -> {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.articles) { article ->
                    NewsItem(article)
                }
            }
        }
        is NewsUiState.Error -> {
            // This is where your message will now appear professionally!
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = state.message, color = Color.Red, textAlign = TextAlign.Center)
            }
        }
    }
}