package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetAvailableFiltersUseCaseTest{

    private lateinit var useCase: GetAvailableFiltersUseCase

    @Before
    fun setup() {
        useCase = GetAvailableFiltersUseCase()
    }

    @Test
    fun `useCase provides all filter values`() {
        FilterType.values().forEach { type ->
            val availableFilters = FilterModel.values().filter { it.type == type }
            assertEquals(availableFilters, useCase.invoke(type))
        }
    }
}