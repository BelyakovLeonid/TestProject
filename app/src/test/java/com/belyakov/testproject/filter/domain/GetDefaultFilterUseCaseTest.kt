package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetDefaultFilterUseCaseTest {

    private lateinit var useCase: GetDefaultFilterUseCase

    @Before
    fun setup() {
        useCase = GetDefaultFilterUseCase()
    }

    @Test
    fun `useCase provides the correct default values`() {
        assertEquals(FilterModel.CATEGORY_ALL, useCase.invoke(FilterType.CATEGORY))
        assertEquals(FilterModel.COUNTRY_US, useCase.invoke(FilterType.COUNTRY))
    }
}