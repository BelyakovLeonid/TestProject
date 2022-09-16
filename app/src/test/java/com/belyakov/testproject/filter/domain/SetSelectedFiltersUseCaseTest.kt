package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.slot
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SetSelectedFiltersUseCaseTest {

    private lateinit var useCase: SetSelectedFiltersUseCase
    private lateinit var repository: FilterRepository

    @Before
    fun setup() {
        repository = mockk()
        useCase = SetSelectedFiltersUseCase(repository)
    }

    @Test
    fun `valid values are saved properly`() = runTest {
        val valuesToSave = listOf(
            FilterModel.CATEGORY_SCIENCE.value,
            FilterModel.COUNTRY_AUSTRALIA.value
        )
        val actualValuesToSave = slot<List<FilterModel>>()
        coEvery { repository.setSelectedFilters(capture(actualValuesToSave)) } returns mockk()

        useCase.invoke(*valuesToSave.toTypedArray())

        assertEquals(valuesToSave, actualValuesToSave.captured.map { it.value })
    }

    @Test
    fun `invalid values are not saved`() = runTest {
        val valuesToSave = listOf(
            "invalidValue1",
            "invalidValue2"
        )
        val actualValuesToSave = slot<List<FilterModel>>()
        coEvery { repository.setSelectedFilters(capture(actualValuesToSave)) } returns mockk()

        useCase.invoke(*valuesToSave.toTypedArray())

        assertEquals(emptyList<FilterModel>(), actualValuesToSave.captured.map { it.value })
    }
}