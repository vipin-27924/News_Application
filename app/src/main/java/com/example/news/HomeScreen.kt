package com.example.news

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NewsHomeScreen(viewModel: Unit) {
    val articles = viewModel.newsList

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) { article ->
            NewsItem(article) // Defined in HomeComponent.kt
        }
    }
}