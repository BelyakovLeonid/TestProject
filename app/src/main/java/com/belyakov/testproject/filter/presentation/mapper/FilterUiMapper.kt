package com.belyakov.testproject.filter.presentation.mapper

import com.belyakov.testproject.R
import com.belyakov.testproject.base.domain.repository.ResourceRepository
import com.belyakov.testproject.filter.domain.model.CategoryFilter
import com.belyakov.testproject.filter.domain.model.CountryFilter
import com.belyakov.testproject.filter.presentation.model.FilterUiModel
import javax.inject.Inject

class FilterUiMapper @Inject constructor(
    private val resourceRepository: ResourceRepository
) {

    fun map(model: CategoryFilter): FilterUiModel {
        return FilterUiModel(
            value = model.value,
            title = getUiTitle(model)
        )
    }

    fun map(model: CountryFilter): FilterUiModel {
        return FilterUiModel(
            value = model.value,
            title = getUiTitle(model)
        )
    }

    private fun getUiTitle(model: CategoryFilter): String {
        return when (model) {
            CategoryFilter.CATEGORY_ALL -> resourceRepository.getString(R.string.filter_category_all)
            CategoryFilter.CATEGORY_BUSINESS -> resourceRepository.getString(R.string.filter_category_business)
            CategoryFilter.CATEGORY_TECHNOLOGY -> resourceRepository.getString(R.string.filter_category_technology)
            CategoryFilter.CATEGORY_SPORTS -> resourceRepository.getString(R.string.filter_category_sports)
            CategoryFilter.CATEGORY_SCIENCE -> resourceRepository.getString(R.string.filter_category_science)
            CategoryFilter.CATEGORY_HEALTH -> resourceRepository.getString(R.string.filter_category_health)
            CategoryFilter.CATEGORY_GENERAL -> resourceRepository.getString(R.string.filter_category_general)
            CategoryFilter.CATEGORY_ENTERTAINMENT -> resourceRepository.getString(R.string.filter_category_entertainment)
        }
    }

    private fun getUiTitle(model: CountryFilter): String {
        return when (model) {
            CountryFilter.COUNTRY_US -> resourceRepository.getString(R.string.filter_category_all)
            CountryFilter.COUNTRY_CHINA -> resourceRepository.getString(R.string.filter_category_business)
            CountryFilter.COUNTRY_ENGLAND -> resourceRepository.getString(R.string.filter_category_technology)
            CountryFilter.COUNTRY_AUSTRALIA -> resourceRepository.getString(R.string.filter_category_sports)
            CountryFilter.COUNTRY_MEXICO -> resourceRepository.getString(R.string.filter_category_science)
            CountryFilter.COUNTRY_POLAND -> resourceRepository.getString(R.string.filter_category_health)
            CountryFilter.COUNTRY_LATVIA -> resourceRepository.getString(R.string.filter_category_general)
            CountryFilter.COUNTRY_NEW_ZEALAND -> resourceRepository.getString(R.string.filter_category_entertainment)
            CountryFilter.COUNTRY_UKRAINE -> resourceRepository.getString(R.string.filter_category_entertainment)
            CountryFilter.COUNTRY_RUSSIA -> resourceRepository.getString(R.string.filter_category_entertainment)
            CountryFilter.COUNTRY_BRAZIL -> resourceRepository.getString(R.string.filter_category_entertainment)
        }
    }
}