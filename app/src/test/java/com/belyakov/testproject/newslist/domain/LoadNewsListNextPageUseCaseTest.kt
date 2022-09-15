package com.belyakov.testproject.newslist.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.slot
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoadNewsListNextPageUseCaseTest {

    private lateinit var useCase: LoadNewsListNextPageUseCase
    private lateinit var repository: NewsListRepository

    @Before
    fun setup() {
        repository = mockk()
        useCase = LoadNewsListNextPageUseCase(repository = repository)
    }

    @Test
    fun `useCase calls the repository with the correct filters`() = runTest {
        val givenFilters = listOf(FilterModel.CATEGORY_SCIENCE, FilterModel.COUNTRY_AUSTRALIA)
        val passedToRepositoryFilters = slot<List<FilterModel>>()
        coEvery { repository.loadNewsNextPage(capture(passedToRepositoryFilters)) } returns mockk()

        useCase.invoke(givenFilters)

        assertEquals(givenFilters, passedToRepositoryFilters.captured)
    }
}