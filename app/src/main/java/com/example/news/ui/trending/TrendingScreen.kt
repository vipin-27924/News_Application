package com.example.news.ui.trending

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.news.R
import com.example.news.data.remote.dto.NewsUiState
import com.example.news.ui.components.HomeNavBar
import com.example.news.ui.components.NewsCard // Ensure you have this imported

@Composable
fun TrendingTopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.md_theme_onPrimaryContainer))
            .padding(vertical = 12.dp), // Added padding for better look
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Trending News",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = androidx.compose.ui.graphics.Color.White // Ensure text is visible on dark bg
        )
    }
}

@Composable
fun Trending_Screen(
    navController: NavHostController = rememberNavController(),
    // Inject the new TrendingViewModel here
    viewModel: TrendingViewModel = viewModel()
) {
    // Read the state from the ViewModel
    val uiState = viewModel.uiState

    Scaffold(
        topBar = { TrendingTopBar() },
        bottomBar = { HomeNavBar(navController = navController) }
    ) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when (uiState) {
                is NewsUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                is NewsUiState.Success -> {
                    // Display the list of articles
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(uiState.articles) { article ->
                            // Reusing your existing NewsCard component
                            NewsCard(article = article)
                        }
                    }
                }

                is NewsUiState.Error -> {
                    Text(
                        text = uiState.message,
                        modifier = Modifier.align(Alignment.Center),
                        color = androidx.compose.ui.graphics.Color.Red
                    )
                }
            }
        }
    }
}