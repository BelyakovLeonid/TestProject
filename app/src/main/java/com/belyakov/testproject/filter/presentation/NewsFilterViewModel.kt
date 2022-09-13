package com.belyakov.testproject.filter.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.belyakov.testproject.filter.domain.GetAvailableCategoryFiltersUseCase
import com.belyakov.testproject.filter.domain.GetAvailableCountryFiltersUseCase
import com.belyakov.testproject.filter.presentation.mapper.FilterUiMapper
import com.belyakov.testproject.filter.presentation.model.FilterState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsFilterViewModel @Inject constructor(
    private val getAvailableCategoryFilters: GetAvailableCategoryFiltersUseCase,
    private val getAvailableCountryFilters: GetAvailableCountryFiltersUseCase,
    private val mapper: FilterUiMapper
) : ViewModel() {

    private val _state = mutableStateOf(FilterState())
    val state: State<FilterState> = _state

    init {
        _state.value = state.value.copy(
            countryFilters = getAvailableCountryFilters().map(mapper::map),
            categoryFilters = getAvailableCategoryFilters().map(mapper::map)
        )
    }
}