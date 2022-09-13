package com.belyakov.testproject.newslist.data.remote.model

class NewsListDto(
    val totalResults: Int,
    val articles: List<NewsDto>,
    val status: String
)
