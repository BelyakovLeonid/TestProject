package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import javax.inject.Inject

class SetSelectedFilterUseCase @Inject constructor(
    private val repository: FilterRepository
) {

    suspend operator fun invoke(filterValue: String?){
        val filter = FilterModel.values().firstOrNull{ it.value == filterValue} ?: return
        repository.setSelectedFilter(filter)
    }
}