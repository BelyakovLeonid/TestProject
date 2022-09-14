package com.belyakov.testproject.filter.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belyakov.testproject.filter.domain.GetAvailableFiltersUseCase
import com.belyakov.testproject.filter.domain.GetSelectedFilterUseCase
import com.belyakov.testproject.filter.domain.model.FilterType
import com.belyakov.testproject.filter.presentation.mapper.FilterUiMapper
import com.belyakov.testproject.filter.presentation.model.FilterState
import com.belyakov.testproject.filter.presentation.model.FilterUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsFilterViewModel @Inject constructor(
    private val getAvailableFilters: GetAvailableFiltersUseCase,
    private val getSelectedFilter: GetSelectedFilterUseCase,
    private val mapper: FilterUiMapper
) : ViewModel() {

    private val _state = mutableStateOf(getDefaultState())
    val state: State<FilterState> = _state

    init {
        viewModelScope.launch {
            _state.value = state.value.copy(
                selectedCategory = mapper.map(getSelectedFilter(FilterType.CATEGORY)),
                selectedCountry = mapper.map(getSelectedFilter(FilterType.COUNTRY))
            )
        }
    }

    fun onCategoryClicked(category: FilterUiModel) {
        _state.value = state.value.copy(
            selectedCategory = category
        )
    }

    fun onCountryClicked(country: FilterUiModel) {
        _state.value = state.value.copy(
            selectedCountry = country
        )
    }

    private fun getDefaultState(): FilterState {
        return FilterState(
            categoryFilters = getAvailableFilters(FilterType.CATEGORY).map(mapper::map),
            countryFilters = getAvailableFilters(FilterType.COUNTRY).map(mapper::map)
        )
    }
}