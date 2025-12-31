package com.example.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.news.ui.theme.NewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsTheme {
                var showSplash by remember { mutableStateOf(true) }
                if (showSplash) {
                    // Call the splash function and switch state after delay
                    splashscreen().splash(onNavigate = { showSplash = false })
                } else {
                    NewsHomeScreen()
                }
            }
        }
    }
}

