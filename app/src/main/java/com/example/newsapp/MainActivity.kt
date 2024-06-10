package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.model.Source
import com.example.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.example.newsapp.presentation.nvgraph.NavGraph
import com.example.newsapp.ui.theme.NewsAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels<MainViewModel>()
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases
    @Inject
    lateinit var dao: NewsDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }
        lifecycleScope.launch {
            dao.upsert(
                article = Article(
                    author = "Manish Singh",
                    content = "In a research note, HSBC estimates that the Indian edtech giant Byju’s, once valued at \$22 billion, is now worth nothing. The write-down in its estimation makes Byju’s one of the most spectacular sta… [+2032 chars]",
                    description = "In a research note, HSBC estimates that the Indian edtech giant Byju's, once valued at \$22 billion, is now worth nothing. HSBC estimates that the Indian edtech giant Byju's, once valued at \$22 billion, is now worth nothing.",
                    publishedAt = "2024-06-07T02:00:49Z",
                    source = Source(id = "techcrunch", name = "TechCrunch"),
                    title = "HSBC believes that \$22 billion Byju’s is now worth zero | TechCrunch",
                    url = "\"https://techcrunch.com/2024/06/06/hsbc-believes-indian-edtech-byjus-currently-worth-zero/",
                    urlToImage = "\"https://techcrunch.com/wp-content/uploads/2023/06/GettyImages-1257740205.jpg?resize=1200,800"
                )
            )
        }
        setContent {
            NewsAppTheme {
                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }
                Surface {
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)

                }
            }
        }
    }
}