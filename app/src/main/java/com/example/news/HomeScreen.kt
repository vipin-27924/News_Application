package com.example.news

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NewsHomeScreen(viewModel: NewsViewModel = viewModel()) { // Use your ACTUAL class
    val articles = viewModel.newsList
    val isLoading = viewModel.loading

    if (isLoading) {
        androidx.compose.material3.CircularProgressIndicator()
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(articles) { article ->
                NewsItem(article)
            }
        }
    }
}
