package com.belyakov.testproject.newslist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.belyakov.testproject.R
import com.belyakov.testproject.base.presentation.navigation.NavigationCommand
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.base.utils.SubscribeToNavigationCommands
import com.belyakov.testproject.newslist.presentation.composable.NewsList
import com.belyakov.testproject.newslist.presentation.composable.NewsListAlertWithButton
import com.belyakov.testproject.newslist.presentation.composable.NewsListAppBar
import com.belyakov.testproject.newslist.presentation.composable.NewsListLoading

object NewsListDestination : TestNewsDestination(route = "newslist")

@Composable
fun NewsListScreen(
    onNavigate: (NavigationCommand) -> Unit,
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    SubscribeToNavigationCommands(
        navigator = viewModel,
        onNavigate = onNavigate
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NewsListAppBar(
            hasFilters = state.hasFilter,
            onNavigateToFilter = viewModel::onFiltersCLicked
        )

        when {
            state.isLoading -> NewsListLoading()
            state.isError -> {
                NewsListAlertWithButton(
                    title = stringResource(R.string.news_list_error),
                    buttonText = stringResource(R.string.news_list_repeat),
                    onButtonCLick = viewModel::onRepeatClick
                )
            }
            state.data.isEmpty() -> {
                NewsListAlertWithButton(
                    title = stringResource(R.string.news_list_page_empty),
                    buttonText = stringResource(R.string.news_list_page_filters_change),
                    onButtonCLick = viewModel::onFiltersCLicked
                )
            }
            else -> {
                NewsList(
                    news = state.data,
                    isNextPageLoading = state.isNextPageLoading,
                    onShowItemAtPosition = viewModel::onShowItemAtPosition,
                    onNewsClick = viewModel::onItemClicked
                )
            }
        }
    }

}

@Preview
@Composable
fun NewsListScreenPreview() {
    NewsListScreen(
        onNavigate = {},
    )
}