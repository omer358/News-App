package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article

class UpsertArticles(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(articles: Article) {
        newsDao.upsert(articles)
    }
}