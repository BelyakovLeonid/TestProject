package com.belyakov.testproject.newslist.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.belyakov.testproject.newslist.presentation.composable.getFakeNewsModel
import com.belyakov.testproject.newslist.presentation.model.NewsListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf<NewsListUiState>(NewsListUiState.Loading)
    val state: State<NewsListUiState> = _state

    init {
        _state.value = NewsListUiState.Content(
            listOf(
                getFakeNewsModel(1),
                getFakeNewsModel(2),
                getFakeNewsModel(3),
                getFakeNewsModel(4),
            )
        )
    }

    fun onNewsClick() {

    }
}