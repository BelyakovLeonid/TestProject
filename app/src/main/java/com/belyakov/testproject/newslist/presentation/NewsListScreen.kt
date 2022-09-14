package com.belyakov.testproject.newslist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.belyakov.testproject.base.presentation.navigation.NavigationCommand
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.base.utils.SubscribeToNavigation
import com.belyakov.testproject.newslist.presentation.composable.NewsList
import com.belyakov.testproject.newslist.presentation.composable.NewsListAppBar

object NewsListDestination : TestNewsDestination(route = "newslist")

@Composable
fun NewsListScreen(
    onNavigate: (NavigationCommand) -> Unit,
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val uiState = viewModel.state.value

    SubscribeToNavigation(
        navigator = viewModel,
        onNavigate = onNavigate
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NewsListAppBar(
            uiState.hasFilter,
            onNavigateToFilter = viewModel::onFiltersCLicked
        )
        NewsList(
            news = uiState.data,
            onNewsClick = viewModel::onItemClicked,
            onShowItemAtPosition = viewModel::onShowItemAtPosition
        )
    }
}

@Preview
@Composable
fun NewsListScreenPreview() {
    NewsListScreen(
        onNavigate = {},
    )
}