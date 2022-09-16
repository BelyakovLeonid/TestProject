package com.belyakov.testproject.newslist.data.mapper

import com.belyakov.testproject.newslist.data.local.model.NewsEntity
import com.belyakov.testproject.newslist.data.remote.model.NewsDto
import com.belyakov.testproject.newslist.data.remote.model.NewsListDto
import com.belyakov.testproject.newslist.data.remote.model.NewsSourceDto
import com.belyakov.testproject.newslist.domain.model.NewsModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.threeten.bp.ZonedDateTime

class NewsDataMapperTest {

    private lateinit var mapper: NewsDataMapper

    @Before
    fun setup() {
        mapper = NewsDataMapper()
    }

    @Test
    fun `mapper maps dto to entity correctly`() {
        val expectedEntity = NewsEntity(
            id = "http://someUrl",
            title = "someTitle",
            imageUrl = "http://someUrlToImage",
            publishedAt = ZonedDateTime.parse("2022-09-15T18:02:31Z"),
            source = "CNN",
            content = "someContent",
        )
        val dto = NewsListDto(
            totalResults = 1,
            articles = listOf(
                NewsDto(
                    publishedAt = "2022-09-15T18:02:31Z",
                    author = "Will Smith",
                    url = "http://someUrl",
                    description = "someDescription",
                    source = NewsSourceDto(
                        name = "CNN",
                        id = "123"
                    ),
                    title = "someTitle",
                    urlToImage = "http://someUrlToImage",
                    content = "someContent",
                )
            ),
            status = "OK",
        )

        val actualEntities = mapper.map(dto)

        assertEquals(1, actualEntities.size)
        assertEquals(expectedEntity, actualEntities.first())
    }

    @Test
    fun `mapper maps dto to entity correctly even with null fields`() {
        val expectedEntity = NewsEntity(
            id = "http://someUrl",
            title = "someTitle",
            imageUrl = null,
            publishedAt = ZonedDateTime.parse("2022-09-15T18:02:31Z"),
            source = null,
            content = "someContent",
        )
        val dto = NewsListDto(
            totalResults = 1,
            articles = listOf(
                NewsDto(
                    publishedAt = "2022-09-15T18:02:31Z",
                    author = null,
                    url = "http://someUrl",
                    description = null,
                    source = NewsSourceDto(
                        name = null,
                        id = null
                    ),
                    title = "someTitle",
                    urlToImage = null,
                    content = "someContent",
                )
            ),
            status = "OK",
        )

        val actualEntities = mapper.map(dto)

        assertEquals(1, actualEntities.size)
        assertEquals(expectedEntity, actualEntities.first())
    }

    @Test
    fun `mapper skips invalid dto`() {
        val dto = NewsListDto(
            totalResults = 1,
            articles = listOf(
                NewsDto(
                    publishedAt = "2022-09-15T18:02:31Z",
                    author = "Will Smith",
                    url = null,
                    description = "someDescription",
                    source = NewsSourceDto(
                        name = "CNN",
                        id = "123"
                    ),
                    title = null,
                    urlToImage = null,
                    content = "someContent",
                ),
                NewsDto(
                    publishedAt = "2022-09-15T18:02:31Z",
                    author = null,
                    url = "http://someUrl",
                    description = null,
                    source = NewsSourceDto(
                        name = "CNN",
                        id = "123"
                    ),
                    title = null,
                    urlToImage = "http://someUrlToImage",
                    content = "someContent",
                ),
            ),
            status = "OK",
        )

        val actualEntities = mapper.map(dto)

        assertEquals(0, actualEntities.size)
    }

    @Test
    fun `mapper maps entity to domain model correctly`() {
        val expectedDomain = NewsModel(
            id = "http://someUrl",
            title = "someTitle",
            imageUrl = "http://someUrlToImage",
            publishedAt = ZonedDateTime.parse("2022-09-15T18:02:31Z"),
            source = "CNN",
            content = "someContent",
        )
        val entity = NewsEntity(
            id = "http://someUrl",
            title = "someTitle",
            imageUrl = "http://someUrlToImage",
            publishedAt = ZonedDateTime.parse("2022-09-15T18:02:31Z"),
            source = "CNN",
            content = "someContent",
        )

        val actualDomain = mapper.map(entity)

        assertEquals(expectedDomain, actualDomain)
    }
}