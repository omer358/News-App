package com.example.newsapp.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertArticles: UpsertArticles,
    val deleteArticles: DeleteArticles,
    val selectArticles: SelectArticles,
    val selectArticle: SelectArticle
)
