package com.belyakov.testproject.filter.presentation.mapper

import com.belyakov.testproject.R
import com.belyakov.testproject.base.domain.repository.ResourceRepository
import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.presentation.model.FilterUiModel
import javax.inject.Inject

class FilterUiMapper @Inject constructor(
    private val resourceRepository: ResourceRepository
) {

    fun map(model: FilterModel): FilterUiModel {
        return FilterUiModel(
            value = model.value,
            title = getUiTitle(model)
        )
    }

    private fun getUiTitle(model: FilterModel): String {
        return when (model) {
            FilterModel.CATEGORY_ALL -> resourceRepository.getString(R.string.filter_category_all)
            FilterModel.CATEGORY_BUSINESS -> resourceRepository.getString(R.string.filter_category_business)
            FilterModel.CATEGORY_TECHNOLOGY -> resourceRepository.getString(R.string.filter_category_technology)
            FilterModel.CATEGORY_SPORTS -> resourceRepository.getString(R.string.filter_category_sports)
            FilterModel.CATEGORY_SCIENCE -> resourceRepository.getString(R.string.filter_category_science)
            FilterModel.CATEGORY_HEALTH -> resourceRepository.getString(R.string.filter_category_health)
            FilterModel.CATEGORY_GENERAL -> resourceRepository.getString(R.string.filter_category_general)
            FilterModel.CATEGORY_ENTERTAINMENT -> resourceRepository.getString(R.string.filter_category_entertainment)

            FilterModel.COUNTRY_US -> resourceRepository.getString(R.string.filter_country_us)
            FilterModel.COUNTRY_CHINA -> resourceRepository.getString(R.string.filter_country_china)
            FilterModel.COUNTRY_ENGLAND -> resourceRepository.getString(R.string.filter_country_england)
            FilterModel.COUNTRY_AUSTRALIA -> resourceRepository.getString(R.string.filter_country_australia)
            FilterModel.COUNTRY_MEXICO -> resourceRepository.getString(R.string.filter_country_mexico)
            FilterModel.COUNTRY_POLAND -> resourceRepository.getString(R.string.filter_country_poland)
            FilterModel.COUNTRY_LATVIA -> resourceRepository.getString(R.string.filter_country_latvia)
            FilterModel.COUNTRY_NEW_ZEALAND -> resourceRepository.getString(R.string.filter_country_new_zealand)
            FilterModel.COUNTRY_UKRAINE -> resourceRepository.getString(R.string.filter_country_ukraine)
            FilterModel.COUNTRY_RUSSIA -> resourceRepository.getString(R.string.filter_country_russia)
            FilterModel.COUNTRY_BRAZIL -> resourceRepository.getString(R.string.filter_country_brazil)
        }
    }
}