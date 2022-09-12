package com.belyakov.testproject.newslist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.filter.presentation.NewsFilterDestination
import com.belyakov.testproject.newsdetail.presentation.NewsDetailDestination
import com.belyakov.testproject.newslist.presentation.composable.NewsList
import com.belyakov.testproject.newslist.presentation.composable.NewsListAppBar
import com.belyakov.testproject.newslist.presentation.composable.getFakeNewsModel

object NewsListDestination : TestNewsDestination(route = "newslist")

@Composable
fun NewsListScreen(
    onNavigateToDetails: (TestNewsDestination) -> Unit,
    onNavigateToFilter: (TestNewsDestination) -> Unit
    //    viewModel: MainViewModel by viewModel
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NewsListAppBar(
            onNavigateToFilter = { onNavigateToFilter(NewsFilterDestination) }
        )
        NewsList(
            news = listOf(
                getFakeNewsModel(1),
                getFakeNewsModel(2),
                getFakeNewsModel(3),
                getFakeNewsModel(4),
                getFakeNewsModel(5),
                getFakeNewsModel(6),
                getFakeNewsModel(7)
            ),
            onNewsClick = { onNavigateToDetails(NewsDetailDestination) }
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