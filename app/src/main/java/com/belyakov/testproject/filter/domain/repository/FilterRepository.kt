package com.belyakov.testproject.filter.domain.repository

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import kotlinx.coroutines.flow.Flow

interface FilterRepository {
    fun getSelectedFilterAsFlow(filterType: FilterType): Flow<FilterModel?>
    suspend fun getSelectedFilter(filterType: FilterType): FilterModel?
    suspend fun setSelectedFilter(filter: FilterModel)
}