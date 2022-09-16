package com.belyakov.testproject.newslist.presentation.model

import com.belyakov.testproject.filter.domain.model.FilterModel

data class NewsListUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val data: List<NewsUiModel> = emptyList(),
    val isNextPageLoading: Boolean = false,
    val hasFilter: Boolean = false,
    val filters: List<FilterModel> = emptyList()
)