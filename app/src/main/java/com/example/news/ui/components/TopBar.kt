package com.example.news.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.news.R


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun NewsTopBar() {

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Latest News",
                style = MaterialTheme.typography.headlineMedium
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = colorResource(R.color.md_theme_onPrimaryContainer),
            scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}
