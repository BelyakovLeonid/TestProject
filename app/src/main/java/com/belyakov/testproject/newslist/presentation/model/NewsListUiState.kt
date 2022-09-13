package com.belyakov.testproject.newslist.presentation.model

sealed interface NewsListUiState {
    object Loading : NewsListUiState
    object Empty : NewsListUiState

    data class Content(
        val data: List<NewsUiModel>
    ) : NewsListUiState
}