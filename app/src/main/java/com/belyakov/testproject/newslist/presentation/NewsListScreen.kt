package com.belyakov.testproject.newslist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.filter.presentation.NewsFilterDestination
import com.belyakov.testproject.newsdetail.presentation.NewsDetailDestination
import com.belyakov.testproject.newslist.presentation.composable.NewsList
import com.belyakov.testproject.newslist.presentation.composable.NewsListAppBar

object NewsListDestination : TestNewsDestination(route = "newslist")

@Composable
fun NewsListScreen(
    onNavigateToDetails: (TestNewsDestination) -> Unit,
    onNavigateToFilter: (TestNewsDestination) -> Unit,
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val uiState = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NewsListAppBar(
            onNavigateToFilter = { onNavigateToFilter(NewsFilterDestination) }
        )
        NewsList(
            news = uiState.data,
            onNewsClick = { onNavigateToDetails(NewsDetailDestination) },
            onShowItemAtPosition = viewModel::onShowItemAtPosition
        )
    }
}

@Preview
@Composable
fun NewsListScreenPreview() {
    NewsListScreen(
        onNavigateToDetails = {},
        onNavigateToFilter = {}
    )
}