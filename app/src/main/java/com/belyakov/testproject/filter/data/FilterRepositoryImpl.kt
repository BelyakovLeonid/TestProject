package com.belyakov.testproject.filter.data

import android.util.Log
import com.belyakov.testproject.filter.data.local.FilterDao
import com.belyakov.testproject.filter.data.mapper.FilterDataMapper
import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import javax.inject.Inject

class FilterRepositoryImpl @Inject constructor(
    private val dao: FilterDao,
    private val mapper: FilterDataMapper
) : FilterRepository {

    override suspend fun getSelectedFilter(filterType: FilterType): FilterModel? {
        Log.d("MyTag","getSelectedFilter $filterType data = ${mapper.map(dao.getFilterById(filterType.name))}")
        return mapper.map(dao.getFilterById(filterType.name))
    }

    override suspend fun setSelectedFilter(filter: FilterModel) {
        dao.insert(mapper.map(filter))
    }
}