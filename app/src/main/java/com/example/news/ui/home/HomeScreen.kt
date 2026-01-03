package com.example.news.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.news.ui.components.NewsCard
import com.example.news.ui.components.NewsTopBar
import com.example.news.data.remote.dto.NewsUiState
import com.example.news.data.remote.dto.NewsViewModel
import com.example.news.ui.components.HomeNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun NewsHomeScreen(viewModel: NewsViewModel = viewModel(),navController: NavHostController = rememberNavController()) {



    val state = viewModel.uiState
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    when (state) {
        is NewsUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is NewsUiState.Success -> {

            Column(
                modifier = Modifier.fillMaxSize()

                    .statusBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally

            )
            {
                NewsTopBar()
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.articles) { article ->
                        NewsCard(article)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
                Scaffold(
                    bottomBar = {
                        // We pass the controller to the NavBar so it can tell the app to move
                        HomeNavBar(navController = navController)
                    }
                ) { innerPadding ->
                    // The NavHost is where the actual page swapping happens
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") { HomeScreen() }
                        composable("trending") {  }
                        composable("saved") {  }
                    }
                }
            }
        }
        is NewsUiState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = state.message, color = Color.Red, textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun HomeScreen() {
    TODO("Not yet implemented")
}