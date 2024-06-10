package com.example.newsapp.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.newsapp.presentation.onboarding.OnBoardingScreen
import com.example.newsapp.presentation.onboarding.OnBoardingViewModel
import com.example.newsapp.presentation.search.SearchScreen
import com.example.newsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String,
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Routes.AppStartNavigation.route,
            startDestination = Routes.OnBoardingScreen.route
        ) {
            composable(
                route = Routes.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = {
                        viewModel.onEvent(it)
                    }
                )
            }
        }
        navigation(
            route = Routes.NewsNavigation.route,
            startDestination = Routes.NewsNavigatorScreen.route
        ) {
            composable(
                route = Routes.NewsNavigatorScreen.route
            ) {
                val viewModel: SearchViewModel = hiltViewModel()
//                val articles = viewModel.news.collectAsLazyPagingItems()
                SearchScreen(state = viewModel.state.value, event = viewModel::onEvent, navigate = {})

            }
        }
    }
}