package com.example.news.ui.trending

import androidx.compose.runtime.Composable
import com.example.news.data.remote.dto.NewsViewModel

// app/src/main/java/com/example/news/ui/trending/TrendingScreen.kt
package com.example.news.ui.trending

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.news.data.remote.dto.NewsUiState
import com.example.news.ui.components.NewsCard

@Composable
fun TrendingNewsScreen(viewModel: NewsViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        // 🔍 Search Bar
        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = { viewModel.onSearchQueryChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Search trending news...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            singleLine = true,
            shape = MaterialTheme.shapes.medium
        )

        Box(modifier = Modifier.fillMaxSize()) {
            when (val state = viewModel.uiState) {
                is NewsUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is NewsUiState.Success -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.articles) { article ->
                            NewsCard(article = article)
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
                is NewsUiState.Error -> {
                    Text(
                        text = state.message,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center).padding(16.dp)
                    )
                }
            }
        }
    }
}