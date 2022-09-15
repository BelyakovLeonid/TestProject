package com.belyakov.testproject.newslist.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.newslist.domain.model.NewsModel
import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.slot
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.threeten.bp.ZonedDateTime

@OptIn(ExperimentalCoroutinesApi::class)
class NewsListAsFlowUseCaseTest {

    private lateinit var useCase: NewsListAsFlowUseCase
    private lateinit var repository: NewsListRepository

    @Before
    fun setup() {
        repository = mockk()
        useCase = NewsListAsFlowUseCase(repository = repository)
    }

    @Test
    fun `useCase provides the news from the repository`() = runTest {
        val savedNews = listOf(
            NewsModel(
                id = "1",
                title = "title1",
                imageUrl = "someUrl",
                publishedAt = ZonedDateTime.now(),
                source = "CNN",
                content = "someContent",
            )
        )
        coEvery { repository.getNewsAsFlow() } returns flowOf(savedNews)

        val receivedNews = useCase.invoke().first()

        assertEquals(savedNews, receivedNews)
    }
}