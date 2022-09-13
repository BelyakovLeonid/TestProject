package com.belyakov.testproject.newsdetail.presentation

import androidx.lifecycle.ViewModel
import com.belyakov.testproject.newslist.presentation.composable.getFakeNewsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor() : ViewModel() {
    val fakeNews = getFakeNewsModel()

    fun onNewsClick() {

    }
}