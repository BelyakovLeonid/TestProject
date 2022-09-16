package com.belyakov.testproject.filter.data.mapper

import com.belyakov.testproject.filter.data.local.model.FilterEntity
import com.belyakov.testproject.filter.domain.model.FilterModel
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class FilterDataMapperTest {

    private lateinit var mapper: FilterDataMapper

    @Before
    fun setup() {
        mapper = FilterDataMapper()
    }

    @Test
    fun `mapper maps entity to domain model correctly`() {
        val expectedDomain = FilterModel.COUNTRY_AUSTRALIA
        val entity = FilterEntity(
            id = "COUNTRY",
            value = "au",
        )

        val actualDomain = mapper.map(entity)

        TestCase.assertEquals(expectedDomain, actualDomain)
    }

    @Test
    fun `mapper returns null if null is given`() {
        val expectedDomain = null
        val entity = null

        val actualDomain = mapper.map(entity)

        TestCase.assertEquals(expectedDomain, actualDomain)
    }

    @Test
    fun `mapper maps domain to entity correctly`() {
        val expectedEntity = FilterEntity(
            id = "CATEGORY",
            value = "health",
        )
        val domain = FilterModel.CATEGORY_HEALTH

        val actualEntity = mapper.map(domain)

        TestCase.assertEquals(expectedEntity, actualEntity)
    }
}
