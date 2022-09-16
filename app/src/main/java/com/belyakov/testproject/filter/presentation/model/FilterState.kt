package com.belyakov.testproject.filter.presentation.model

data class FilterState(
    val categoryFilters: List<FilterUiModel> = emptyList(),
    val countryFilters: List<FilterUiModel> = emptyList(),
    val selectedCategory: FilterUiModel? = null,
    val selectedCountry: FilterUiModel? = null,
)