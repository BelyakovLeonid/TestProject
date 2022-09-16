package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetSelectedFilterAsFlowUseCaseTest {

    private lateinit var useCase: GetSelectedFilterAsFlowUseCase
    private lateinit var getDefaultFilter: GetDefaultFilterUseCase
    private lateinit var repository: FilterRepository

    @Before
    fun setup() {
        repository = mockk()
        getDefaultFilter = GetDefaultFilterUseCase()
        useCase = GetSelectedFilterAsFlowUseCase(
            getDefaultFilter = getDefaultFilter,
            repository = repository
        )
    }

    @Test
    fun `useCase provides values from the repository if there are any`() = runTest {
        val savedFilters = listOf(FilterModel.CATEGORY_SCIENCE, FilterModel.COUNTRY_RUSSIA)
        every { repository.getSelectedFiltersAsFlow() } returns flowOf(savedFilters)

        val actualFilters = useCase.invoke().first()

        assertEquals(savedFilters, actualFilters)
    }

    @Test
    fun `useCase provides default values if the repository doesn't contain the correspondent values`() = runTest {
        val defaultFilters = FilterType.values().map { type -> getDefaultFilter(type) }
        val savedFilters = emptyList<FilterModel>()
        every { repository.getSelectedFiltersAsFlow() } returns flowOf(savedFilters)

        val actualFilters = useCase.invoke().first()

        assertEquals(defaultFilters, actualFilters)
    }
}