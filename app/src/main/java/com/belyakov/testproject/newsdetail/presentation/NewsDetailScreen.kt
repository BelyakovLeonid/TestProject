package com.belyakov.testproject.newsdetail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.belyakov.testproject.base.presentation.navigation.NavigationCommand
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.newsdetail.presentation.composable.NewsDetailedAppBar
import com.belyakov.testproject.newsdetail.presentation.composable.NewsDetailedText
import com.belyakov.testproject.newsdetail.presentation.composable.NewsDetailedTop

object NewsDetailDestination : TestNewsDestination(route = "newsdetail")

@Composable
fun NewsDetailScreen(
    onNavigate: (NavigationCommand) -> Unit,
    viewModel: NewsDetailViewModel = viewModel()
) {
    val fakeNews = viewModel.fakeNews

    Column(modifier = Modifier.fillMaxSize()) {
        NewsDetailedAppBar(
            title = fakeNews.title,
            onBackClick = { onNavigate(NavigationCommand.NavigateBack) }
        )
        NewsDetailedTop(newsModel = fakeNews)
        NewsDetailedText(text = fakeNews.title)
    }
}

@Preview
@Composable
fun NewsDetailScreenPreview() {
    NewsDetailScreen(
        onNavigate = {}
    )
}