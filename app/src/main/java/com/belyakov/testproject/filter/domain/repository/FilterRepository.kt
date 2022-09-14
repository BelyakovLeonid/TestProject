package com.belyakov.testproject.filter.domain.repository

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType

interface FilterRepository {
    suspend fun getSelectedFilter(filterType: FilterType): FilterModel?
    suspend fun setSelectedFilter(filter: FilterModel)
}