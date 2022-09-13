package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.CategoryFilter
import javax.inject.Inject

class GetAvailableCategoryFiltersUseCase @Inject constructor() {

    operator fun invoke(): List<CategoryFilter> {
        return CategoryFilter.values().toList()
    }
}