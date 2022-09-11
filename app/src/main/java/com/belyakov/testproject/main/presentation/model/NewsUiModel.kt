package com.belyakov.testproject.main.presentation.model

data class NewsUiModel(
    val id: Long,
    val title: String,
    val author: String,
    val date: String,
    val imageUrl: String
)