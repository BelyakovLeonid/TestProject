package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.CountryFilter
import javax.inject.Inject

class GetAvailableCountryFiltersUseCase @Inject constructor() {

    operator fun invoke(): List<CountryFilter> {
        return CountryFilter.values().toList()
    }
}