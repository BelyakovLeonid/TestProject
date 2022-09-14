package com.belyakov.testproject.filter.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import javax.inject.Inject

class GetDefaultFilterUseCase @Inject constructor() {

    operator fun invoke(type: FilterType): FilterModel {
        return when (type) {
            FilterType.CATEGORY -> FilterModel.CATEGORY_ALL
            FilterType.COUNTRY -> FilterModel.COUNTRY_US
        }
    }
}