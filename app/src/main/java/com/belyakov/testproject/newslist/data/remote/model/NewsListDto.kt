package com.belyakov.testproject.newslist.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
class NewsListDto(
    val totalResults: Int,
    val articles: List<NewsDto>,
    val status: String
)
