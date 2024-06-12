package com.example.newsapp.domain.usecases.news

import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository

class UpsertArticles(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(articles: Article) {
        newsRepository.upsertArticle(articles)
    }
}