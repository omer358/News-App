package com.example.newsapp.presentation.detials

import com.example.newsapp.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticles(val article: Article) : DetailsEvent()

    data object RemoveSideEffect : DetailsEvent()
}