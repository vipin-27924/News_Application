package com.example.news.ui.components

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.news.R

sealed class NavScreen(val route: String, val title: String, val icon: ImageVector) {
    object Home : NavScreen("home", "Home", Icons.Default.Home)
    object Trending : NavScreen("trending", "Trending", Icons.Default.Whatshot)
    object Saved : NavScreen("saved", "Saved", Icons.Default.Bookmark)
}

@Composable
fun HomeNavBar(navController: NavController) {
    val items = listOf(NavScreen.Home, NavScreen.Trending, NavScreen.Saved)
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.navigationBarsPadding(),
        tonalElevation = 8.dp
    ) {
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                          },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.md_theme_onPrimaryContainer),
                    indicatorColor = colorResource(id = R.color.md_theme_surfaceVariant)
                )
            )
        }
    }
}