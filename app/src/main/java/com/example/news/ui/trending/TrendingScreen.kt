import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
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
import com.example.news.data.remote.dto.NewsViewModel
import com.example.news.ui.components.HomeNavBar
import com.example.news.ui.home.NewsList

@Preview
@Composable
fun TreendingTopBar(){
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(color = colorResource(R.color.md_theme_onPrimaryContainer))
            .height(28.dp),

    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .size(28.dp),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Trending News",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
    }
}




@Composable
fun Trending_Screen(viewModel: NewsViewModel = viewModel()
                    ,navController: NavHostController = rememberNavController()){
    Scaffold (
        topBar = {
            TreendingTopBar()
        },
        bottomBar = {
            HomeNavBar(navController = navController)
        }
    ){}
}