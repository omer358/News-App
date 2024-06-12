package com.example.newsapp.domain.usecases.news

import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(url: String): Article? {
        return  newsRepository.selectArticle(url)
    }
}