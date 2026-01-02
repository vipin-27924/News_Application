package com.example.news.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.R
import kotlinx.coroutines.delay

class splashscreen {
    @Composable
    fun splash(onNavigate: () -> Unit){
        LaunchedEffect(Unit) {
            delay(2000)
            onNavigate()
        }
        Column(
            modifier = Modifier.Companion.fillMaxSize()
                .background(Color.Companion.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        )
        {
            Image(
                contentDescription = null,
                painter = painterResource(id = R.drawable.splash),
                modifier = Modifier.Companion.size(150.dp)
            )
            Spacer(modifier = Modifier.Companion.height(10.dp))
            Text(
                text = "Latest News",
                color = Color.Companion.White,
                fontSize = 24.sp,
                fontFamily = FontFamily.Companion.SansSerif
            )
        }
    }
}