package com.example.newsapp.presentation.detials

sealed class DetailsEvent {
    data object SaveArticles : DetailsEvent()
}