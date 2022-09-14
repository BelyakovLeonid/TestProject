package com.belyakov.testproject.newslist.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belyakov.testproject.base.presentation.navigation.TestNewsNavigator
import com.belyakov.testproject.filter.presentation.NewsFilterDestination
import com.belyakov.testproject.newsdetail.presentation.NewsDetailDestination
import com.belyakov.testproject.newslist.domain.LoadNewsListFirstPageUseCase
import com.belyakov.testproject.newslist.domain.NewsListAsFlowUseCase
import com.belyakov.testproject.newslist.presentation.mapper.NewsUiMapper
import com.belyakov.testproject.newslist.presentation.model.NewsListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsAsFlow: NewsListAsFlowUseCase,
    private val loadNewsNextPage: LoadNewsListFirstPageUseCase,
    private val mapper: NewsUiMapper,
    private val navigator: TestNewsNavigator
) : ViewModel(), TestNewsNavigator by navigator {

    private val _state = mutableStateOf(NewsListUiState.DEFAULT)
    val state: State<NewsListUiState> = _state

    private var loadingPageJob: Job? = null

    private val isPageLoading: Boolean
        get() = loadingPageJob?.isActive == true

    init {
        subscribeToNews()
        loadNextPage()
    }

    fun onShowItemAtPosition(position: Int) {
        if (position == state.value.data.lastIndex && !isPageLoading) {
            loadNextPage()
        }
    }

    fun onItemClicked() {
        navigator.navigateTo(NewsDetailDestination)
    }

    fun onFiltersCLicked() {
        navigator.navigateTo(NewsFilterDestination)
    }

    private fun loadNextPage() {
        if (!isPageLoading) {
            loadingPageJob = viewModelScope.launch {
                loadNewsNextPage()
            }
        }
    }

    private fun subscribeToNews() {
        getNewsAsFlow()
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
}