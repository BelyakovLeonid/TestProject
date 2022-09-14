package com.belyakov.testproject.newslist.presentation.model

data class NewsListUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val data: List<NewsUiModel> = emptyList(),
    val isNextPageLoading: Boolean = false,
    val hasFilter: Boolean = false
)