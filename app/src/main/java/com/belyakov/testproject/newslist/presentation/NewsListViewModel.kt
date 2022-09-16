package com.belyakov.testproject.newslist.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belyakov.testproject.base.presentation.navigation.TestNewsNavigator
import com.belyakov.testproject.base.utils.launchCatching
import com.belyakov.testproject.filter.domain.GetDefaultFilterUseCase
import com.belyakov.testproject.filter.domain.GetSelectedFilterAsFlowUseCase
import com.belyakov.testproject.filter.presentation.NewsFilterDestination
import com.belyakov.testproject.newsdetail.presentation.NewsDetailDestination
import com.belyakov.testproject.newslist.domain.LoadNewsListFirstPageUseCase
import com.belyakov.testproject.newslist.domain.LoadNewsListNextPageUseCase
import com.belyakov.testproject.newslist.domain.NewsListAsFlowUseCase
import com.belyakov.testproject.newslist.presentation.mapper.NewsUiMapper
import com.belyakov.testproject.newslist.presentation.model.NewsListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsAsFlow: NewsListAsFlowUseCase,
    private val loadNewsFirstPage: LoadNewsListFirstPageUseCase,
    private val loadNewsNextPage: LoadNewsListNextPageUseCase,
    private val getDefaultFilter: GetDefaultFilterUseCase,
    private val getSelectedFilterAsFlow: GetSelectedFilterAsFlowUseCase,
    private val mapper: NewsUiMapper,
    private val navigator: TestNewsNavigator
) : ViewModel(), TestNewsNavigator by navigator {

    private val _state = mutableStateOf(NewsListUiState())
    val state: State<NewsListUiState> = _state

    private var loadingPageJob: Job? = null
    private var subscribeToNewsJob: Job? = null

    private val isPageLoading: Boolean
        get() = loadingPageJob?.isActive == true

    init {
        subscribeToFilters()
    }

    fun onRepeatClick() {
        loadFirstPage()
    }

    fun onShowItemAtPosition(position: Int) {
        if (position == state.value.data.lastIndex && !isPageLoading) {
            loadNextPage()
        }
    }

    fun onItemClicked(itemId: String) {
        navigator.navigateTo(NewsDetailDestination(itemId))
    }

    fun onFiltersCLicked() {
        navigator.navigateTo(NewsFilterDestination)
    }

    private fun subscribeToFilters() {
        getSelectedFilterAsFlow()
            .distinctUntilChanged()
            .onEach { filters ->
                val isAnyFilterSelected = filters.any { filter -> filter != getDefaultFilter(filter.type) }
                _state.value = state.value.copy(
                    hasFilter = isAnyFilterSelected,
                    filters = filters
                )
                loadFirstPage()
            }
            .launchIn(viewModelScope)
    }

    private fun loadNextPage() {
        if (!isPageLoading) {
            loadingPageJob = viewModelScope.launchCatching(
                onError = ::onLoadNextPageError
            ) {
                _state.value = state.value.copy(isNextPageLoading = true)
                loadNewsNextPage(state.value.filters)
                _state.value = state.value.copy(isNextPageLoading = false)
            }
        }
    }

    private fun loadFirstPage() {
        loadingPageJob?.cancel()
        loadingPageJob = viewModelScope.launchCatching(
            onError = ::onLoadFirstPageError
        ) {
            _state.value = state.value.copy(isLoading = true)
            loadNewsFirstPage(state.value.filters)
            subscribeToNews()
        }
    }

    private fun subscribeToNews() {
        subscribeToNewsJob?.cancel()
        subscribeToNewsJob = getNewsAsFlow()
            .onEach { news ->
                _state.value = state.value.copy(
                    isLoading = false,
                    isError = false,
                    isNextPageLoading = false,
                    data = news.map(mapper::map)
                )
            }
            .launchIn(viewModelScope)
    }

    private fun onLoadFirstPageError(t: Throwable){
        _state.value = state.value.copy(
            isLoading = false,
            isError = true
        )
    }

    private fun onLoadNextPageError(t: Throwable){
        _state.value = state.value.copy(
            isNextPageLoading = false
        )
    }
}
