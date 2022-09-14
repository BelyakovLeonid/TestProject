package com.belyakov.testproject.filter.data

import com.belyakov.testproject.filter.data.local.FilterDao
import com.belyakov.testproject.filter.data.mapper.FilterDataMapper
import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FilterRepositoryImpl @Inject constructor(
    private val dao: FilterDao,
    private val mapper: FilterDataMapper
) : FilterRepository {

    override fun getSelectedFiltersAsFlow(): Flow<List<FilterModel>> {
        return dao.getFiltersAsFlow().map { filtersEntities ->
            filtersEntities.mapNotNull(mapper::map)
        }
    }

    override suspend fun getSelectedFilter(filterType: FilterType): FilterModel? {
        return mapper.map(dao.getFilterById(filterType.name))
    }

    override suspend fun setSelectedFilters(filters: List<FilterModel>) {
        val filterEntities = filters.map(mapper::map)
        dao.insert(filterEntities)
    }
}