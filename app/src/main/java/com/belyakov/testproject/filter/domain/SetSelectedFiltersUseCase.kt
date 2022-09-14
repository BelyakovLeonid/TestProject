package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import javax.inject.Inject

class SetSelectedFiltersUseCase @Inject constructor(
    private val repository: FilterRepository
) {

    suspend operator fun invoke(vararg filterValues: String?) {
        val filterModels = filterValues.mapNotNull { filterValue ->
            FilterModel.values().firstOrNull { it.value == filterValue }
        }
        repository.setSelectedFilters(filterModels)
    }
}