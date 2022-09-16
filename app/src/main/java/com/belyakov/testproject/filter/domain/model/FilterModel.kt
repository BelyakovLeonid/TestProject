package com.belyakov.testproject.filter.domain.model

enum class FilterModel(
    val value: String?,
    val type: FilterType
) {
    CATEGORY_ALL(null, FilterType.CATEGORY),
    CATEGORY_BUSINESS("business", FilterType.CATEGORY),
    CATEGORY_TECHNOLOGY("technology", FilterType.CATEGORY),
    CATEGORY_SPORTS("sports", FilterType.CATEGORY),
    CATEGORY_SCIENCE("science", FilterType.CATEGORY),
    CATEGORY_HEALTH("health", FilterType.CATEGORY),
    CATEGORY_GENERAL("general", FilterType.CATEGORY),
    CATEGORY_ENTERTAINMENT("entertainment", FilterType.CATEGORY),

    COUNTRY_US("us", FilterType.COUNTRY),
    COUNTRY_CHINA("ch", FilterType.COUNTRY),
    COUNTRY_ENGLAND("en", FilterType.COUNTRY),
    COUNTRY_AUSTRALIA("au", FilterType.COUNTRY),
    COUNTRY_MEXICO("mx", FilterType.COUNTRY),
    COUNTRY_POLAND("pl", FilterType.COUNTRY),
    COUNTRY_LATVIA("lt", FilterType.COUNTRY),
    COUNTRY_NEW_ZEALAND("nz", FilterType.COUNTRY),
    COUNTRY_UKRAINE("ua", FilterType.COUNTRY),
    COUNTRY_RUSSIA("ru", FilterType.COUNTRY),
    COUNTRY_BRAZIL("br", FilterType.COUNTRY);
}

enum class FilterType{
    CATEGORY, COUNTRY
}