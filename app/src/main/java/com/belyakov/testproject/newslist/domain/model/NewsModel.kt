package com.belyakov.testproject.newslist.domain.model

import org.threeten.bp.LocalDate

class NewsModel(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val publishedAt: LocalDate,
    val source: String,
    val content: String
)