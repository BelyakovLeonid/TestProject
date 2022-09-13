package com.belyakov.testproject.newslist.presentation.model

data class NewsListUiState(
    val isLoading: Boolean,
    val isError: Boolean,
    val data: List<NewsUiModel>,
    val isNextPageLoading: Boolean
) {

    companion object {
        val DEFAULT: NewsListUiState
            get() = NewsListUiState(
                isLoading = true,
                isError = false,
                data = emptyList(),
                isNextPageLoading = false
            )
    }
}