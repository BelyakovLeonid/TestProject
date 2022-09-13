package com.belyakov.testproject.filter.domain.model

enum class CategoryFilter(
    categoryValue: String?
) : FilterModel {
    CATEGORY_ALL(null),
    CATEGORY_BUSINESS("business"),
    CATEGORY_TECHNOLOGY("technology"),
    CATEGORY_SPORTS("sports"),
    CATEGORY_SCIENCE("science"),
    CATEGORY_HEALTH("health"),
    CATEGORY_GENERAL("general"),
    CATEGORY_ENTERTAINMENT("entertainment");

    override val value: String? = categoryValue
}
