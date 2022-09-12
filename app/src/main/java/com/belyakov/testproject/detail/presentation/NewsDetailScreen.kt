package com.belyakov.testproject.detail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.belyakov.testproject.detail.presentation.composable.NewsDetailedAppBar
import com.belyakov.testproject.detail.presentation.composable.NewsDetailedText
import com.belyakov.testproject.detail.presentation.composable.NewsDetailedTop
import com.belyakov.testproject.main.presentation.MainScreen
import com.belyakov.testproject.main.presentation.composable.getFakeNewsModel

@Composable
fun NewsDetailScreen(
    //    viewModel: MainViewModel by viewModel
) {
    val fakeNews = getFakeNewsModel()

    Column(modifier = Modifier.fillMaxSize()) {
        NewsDetailedAppBar(
            title = fakeNews.title,
            onBackClick = { }
        )
        NewsDetailedTop(newsModel = fakeNews)
        NewsDetailedText(text = fakeNews.title)
    }
}

@Preview
@Composable
fun NewsDetailScreenPreview() {
    NewsDetailScreen()
}