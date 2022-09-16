package com.belyakov.testproject.filter.data.mapper

import com.belyakov.testproject.filter.data.local.model.FilterEntity
import com.belyakov.testproject.filter.domain.model.FilterModel
import javax.inject.Inject

class FilterDataMapper @Inject constructor() {

    fun map(entity: FilterEntity?): FilterModel? {
        return if (entity == null) {
            null
        } else {
            FilterModel.values().firstOrNull { it.value == entity.value }
        }
    }

    fun map(model: FilterModel): FilterEntity {
        return FilterEntity(
            id = model.type.name,
            value = model.value
        )
    }
}