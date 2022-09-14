package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import javax.inject.Inject

class GetSelectedFilterUseCase @Inject constructor(
    private val repository: FilterRepository
) {

    suspend operator fun invoke(filterType: FilterType): FilterModel {
        return repository.getSelectedFilter(filterType) ?: getDefaultFilter(filterType)
    }

    private fun getDefaultFilter(type: FilterType): FilterModel {
        return when (type) {
            FilterType.CATEGORY -> FilterModel.CATEGORY_ALL
            FilterType.COUNTRY -> FilterModel.COUNTRY_US
        }
    }
}