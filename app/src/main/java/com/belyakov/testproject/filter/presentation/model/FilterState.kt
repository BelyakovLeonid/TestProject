package com.belyakov.testproject.filter.presentation.model

data class FilterState(
    val categoryFilters: List<FilterUiModel> = emptyList(),
    val countryFilters: List<FilterUiModel> = emptyList(),
)