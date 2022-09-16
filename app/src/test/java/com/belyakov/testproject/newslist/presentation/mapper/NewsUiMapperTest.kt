package com.belyakov.testproject.newslist.presentation.mapper

import com.belyakov.testproject.R
import com.belyakov.testproject.base.domain.repository.ResourceRepository
import com.belyakov.testproject.newslist.domain.model.NewsModel
import com.belyakov.testproject.newslist.presentation.model.NewsUiModel
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.threeten.bp.ZonedDateTime

class NewsUiMapperTest {

    private lateinit var mapper: NewsUiMapper

    @Before
    fun setup() {
        mapper = NewsUiMapper(
            resourceRepository = FakeResourceRepository()
        )
    }

    @Test
    fun `mapper maps domain model to ui model correctly`() {
        val domain = NewsModel(
            id = "1",
            title = "title1",
            imageUrl = "someUrl",
            publishedAt = ZonedDateTime.now(),
            source = "CNN",
            content = "someContent",
        )
        val expectedUi = NewsUiModel(
            id = domain.id,
            title = domain.title,
            source = "CNN",
            date = "Recently",
            imageUrl = domain.imageUrl,
            content = domain.content
        )

        val actualUi = mapper.map(domain)

        TestCase.assertEquals(expectedUi, actualUi)
    }

    @Test
    fun `mapping of date X minutes ago`() {
        val minutesAgo = 10L
        val expectedDateString = "$minutesAgo minutes ago"
        val date = ZonedDateTime.now().minusMinutes(minutesAgo)

        val actualDateString = mapper.formatPublishDate(date)

        TestCase.assertEquals(expectedDateString, actualDateString)
    }

    @Test
    fun `mapping of date X hours ago`() {
        val hoursAgo = 10L
        val expectedDateString = "$hoursAgo hours ago"
        val date = ZonedDateTime.now().minusHours(hoursAgo)

        val actualDateString = mapper.formatPublishDate(date)

        TestCase.assertEquals(expectedDateString, actualDateString)
    }

    @Test
    fun `mapping of date X days ago`() {
        val daysAgo = 10L
        val expectedDateString = "$daysAgo days ago"
        val date = ZonedDateTime.now().minusDays(daysAgo)

        val actualDateString = mapper.formatPublishDate(date)

        TestCase.assertEquals(expectedDateString, actualDateString)
    }

    @Test
    fun `mapping of date X years ago`() {
        val yearsAgo = 2L
        val expectedDateString = "$yearsAgo years ago"
        val date = ZonedDateTime.now()
            .minusYears(yearsAgo)
            .minusDays(yearsAgo)

        val actualDateString = mapper.formatPublishDate(date)

        TestCase.assertEquals(expectedDateString, actualDateString)
    }

    private class FakeResourceRepository : ResourceRepository {
        override fun getString(resId: Int): String {
            return if (resId == R.string.news_recently) {
                "Recently"
            } else {
                throw AssertionError("Unexpected resId")
            }
        }

        override fun getString(resId: Int, vararg arguments: Any): String = ""

        override fun getQuantityString(resId: Int, argument: Int): String {
            return when (resId) {
                R.plurals.news_minutes_before -> "$argument minutes ago"
                R.plurals.news_hours_before -> "$argument hours ago"
                R.plurals.news_days_before -> "$argument days ago"
                R.plurals.news_years_before -> "$argument years ago"
                else -> throw AssertionError("Unexpected resId")
            }
        }
    }
}
