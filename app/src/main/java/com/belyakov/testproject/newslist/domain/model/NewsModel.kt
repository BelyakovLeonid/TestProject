package com.belyakov.testproject.newslist.domain.model

import org.threeten.bp.LocalDate

class NewsModel(
    val id: Int,
    val title: String,
    val urlToImage: String,
    val publishedAt: LocalDate,
    val source: String,
    val content: String
)