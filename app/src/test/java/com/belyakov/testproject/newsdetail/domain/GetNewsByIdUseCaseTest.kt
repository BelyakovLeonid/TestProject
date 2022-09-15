package com.belyakov.testproject.newsdetail.domain

import com.belyakov.testproject.filter.domain.GetDefaultFilterUseCase
import com.belyakov.testproject.filter.domain.GetSelectedFilterUseCase
import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import com.belyakov.testproject.newsdetail.domain.repository.NewsDetailRepository
import com.belyakov.testproject.newslist.domain.model.NewsModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetNewsByIdUseCaseTest{

    private lateinit var useCase: GetNewsByIdUseCase
    private lateinit var repository: NewsDetailRepository

    @Before
    fun setup() {
        repository = mockk()
        useCase = GetNewsByIdUseCase(repository = repository)
    }

    @Test
    fun `useCase calls the repository with the correct id`() = runTest {
        val givenId = "testId"
        val passedToRepositoryId = slot<String>()
        coEvery { repository.getNewsById(capture(passedToRepositoryId)) } returns mockk()

        useCase.invoke(givenId)

        assertEquals(givenId, passedToRepositoryId.captured)
    }
}