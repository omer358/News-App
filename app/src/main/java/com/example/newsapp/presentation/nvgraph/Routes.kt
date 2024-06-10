package com.example.newsapp.presentation.nvgraph

sealed class Routes(
    val route: String
){
    data object OnBoardingScreen: Routes("onBoardingScreen")
    data object HomeScreen: Routes("homeScreen")
    data object SearchScreen: Routes("SearchScreen")
    data object BookmarkScreen: Routes("bookmarkScreen")
    data object DetailsScreen: Routes("detailsScreen")
    data object AppStartNavigation: Routes(route = "appStartScreen")
    data object NewsNavigation: Routes(route = "newsScreen")
    data object NewsNavigatorScreen: Routes(route = "newsNavigatorScreen")


}