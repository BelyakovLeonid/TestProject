package com.belyakov.testproject.newslist.presentation.model

data class NewsUiModel(
    val id: Int,
    val title: String,
    val author: String,
    val date: String,
    val imageUrl: String
)