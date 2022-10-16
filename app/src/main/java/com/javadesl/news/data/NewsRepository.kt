package com.javadesl.news.data

import com.javadesl.news.api.NewsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor
    (
    private val newsApi: NewsApi
) {
    suspend fun getNews() = newsApi.getNews("irinn")
}