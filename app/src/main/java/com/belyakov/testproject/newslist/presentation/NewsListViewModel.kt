package com.belyakov.testproject.newslist.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belyakov.testproject.newslist.domain.LoadNewsListFirstPageUseCase
import com.belyakov.testproject.newslist.domain.NewsListAsFlowUseCase
import com.belyakov.testproject.newslist.presentation.mapper.NewsUiMapper
import com.belyakov.testproject.newslist.presentation.model.NewsListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsAsFlow: NewsListAsFlowUseCase,
    private val loadNewsFirstPage: LoadNewsListFirstPageUseCase,
    private val mapper: NewsUiMapper
) : ViewModel() {

    private val _state = mutableStateOf<NewsListUiState>(NewsListUiState.Loading)
    val state: State<NewsListUiState> = _state

    init {
        subscribeToNews()
        loadFirstPage()
    }

    private fun loadFirstPage() {
        viewModelScope.launch {
            loadNewsFirstPage()
        }
    }

    private fun subscribeToNews() {
        getNewsAsFlow()
            .onEach { news ->
                _state.value = NewsListUiState.Content(
                    data = news.map(mapper::map)
                )
            }
            .launchIn(viewModelScope)
    }
}