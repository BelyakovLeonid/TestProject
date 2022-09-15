package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetSelectedFilterUseCaseTest {

    private lateinit var useCase: GetSelectedFilterUseCase
    private lateinit var repository: FilterRepository
    private lateinit var getDefaultFilterUseCase: GetDefaultFilterUseCase

    @Before
    fun setup() {
        repository = mockk()
        getDefaultFilterUseCase = mockk()
        useCase = GetSelectedFilterUseCase(
            getDefaultFilter = getDefaultFilterUseCase,
            repository = repository
        )
    }

    @Test
    fun `useCase provides values from the repository if there are any`() = runTest {
        val savedFilter = FilterModel.CATEGORY_SCIENCE
        coEvery { repository.getSelectedFilter(savedFilter.type) } returns savedFilter

        val actualFilter = useCase.invoke(savedFilter.type)
        assertEquals(savedFilter, actualFilter)
    }

    @Test
    fun `useCase provides default value if there are no value stored`() = runTest {
        val defaultFilter = FilterModel.COUNTRY_RUSSIA
        val savedFilter = null
        coEvery { repository.getSelectedFilter(any()) } returns savedFilter
        every { getDefaultFilterUseCase.invoke(any()) } returns defaultFilter

        val actualFilter = useCase.invoke(defaultFilter.type)
        assertEquals(defaultFilter, actualFilter)
    }
}