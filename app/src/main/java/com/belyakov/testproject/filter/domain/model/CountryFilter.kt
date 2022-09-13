package com.belyakov.testproject.filter.domain.model

enum class CountryFilter(
    countryValue: String
) : FilterModel {
    COUNTRY_US("us"),
    COUNTRY_CHINA("ch"),
    COUNTRY_ENGLAND("en"),
    COUNTRY_AUSTRALIA("au"),
    COUNTRY_MEXICO("mx"),
    COUNTRY_POLAND("pl"),
    COUNTRY_LATVIA("lt"),
    COUNTRY_NEW_ZEALAND("nz"),
    COUNTRY_UKRAINE("ua"),
    COUNTRY_RUSSIA("ru"),
    COUNTRY_BRAZIL("br");

    override val value: String? = countryValue
}