import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.news.R
import com.example.news.data.remote.dto.NewsUiState
import com.example.news.data.remote.dto.NewsViewModel
import com.example.news.ui.components.HomeNavBar
import com.example.news.ui.components.NewsCard
import com.example.news.ui.home.NewsList


@Composable
fun Trending_Screen(viewModel: NewsViewModel
                    ,navController: NavHostController = rememberNavController()){

    Column (
        modifier = Modifier.fillMaxSize()
            .background(color = colorResource(R.color.md_theme_surfaceVariant))
    ){
        val state = viewModel.uiState
        when (state) {
            is NewsUiState.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            is NewsUiState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.articles) { article ->
                        NewsCard(article)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
            is NewsUiState.Error -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = state.message, color = Color.Red)
                }
            }
        }    }
}