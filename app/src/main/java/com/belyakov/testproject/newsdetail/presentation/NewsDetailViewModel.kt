package com.belyakov.testproject.newsdetail.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belyakov.testproject.newsdetail.domain.GetNewsByIdUseCase
import com.belyakov.testproject.newslist.presentation.mapper.NewsUiMapper
import com.belyakov.testproject.newslist.presentation.model.NewsUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getNewsById: GetNewsByIdUseCase,
    mapper: NewsUiMapper
) : ViewModel() {

    private val newsId: String = checkNotNull(savedStateHandle["newsId"])

    private val _state = mutableStateOf<NewsUiModel?>(null)
    val state: State<NewsUiModel?> = _state

    init {
        viewModelScope.launch {
            _state.value = mapper.map(getNewsById(newsId))
        }
    }
}