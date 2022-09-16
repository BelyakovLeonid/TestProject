package com.belyakov.testproject.newslist.presentation.model

data class NewsUiModel(
    val id: String,
    val title: String,
    val source: String,
    val date: String,
    val imageUrl: String?,
    val content: String
)