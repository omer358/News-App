package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article

class DeleteArticles(
    private val newsDao: NewsDao
) {

    suspend fun invoke(article: Article) {
        newsDao.delete(article)
    }
}