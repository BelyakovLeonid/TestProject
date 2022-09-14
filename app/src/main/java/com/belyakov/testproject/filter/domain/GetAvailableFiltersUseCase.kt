package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import javax.inject.Inject

class GetAvailableFiltersUseCase @Inject constructor() {

    operator fun invoke(filterType: FilterType): List<FilterModel> {
        return FilterModel.values().toList().filter { it.type == filterType }
    }
}