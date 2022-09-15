package com.belyakov.testproject.newslist.domain.model

import org.threeten.bp.ZonedDateTime

data class NewsModel(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val publishedAt: ZonedDateTime,
    val source: String?,
    val content: String
)