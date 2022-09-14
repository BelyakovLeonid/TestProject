package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSelectedFilterAsFlowUseCase @Inject constructor(
    private val getDefaultFilter: GetDefaultFilterUseCase,
    private val repository: FilterRepository
) {

    operator fun invoke(filterType: FilterType): Flow<FilterModel> {
        return repository.getSelectedFilterAsFlow(filterType)
            .map { it ?: getDefaultFilter(filterType) }
            .distinctUntilChanged()
    }
}