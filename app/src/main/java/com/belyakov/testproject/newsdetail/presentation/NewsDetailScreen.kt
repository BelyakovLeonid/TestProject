package com.belyakov.testproject.newsdetail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.belyakov.testproject.base.presentation.navigation.NavigationCommand
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.base.utils.encodeUrl
import com.belyakov.testproject.newsdetail.presentation.composable.NewsDetailedAppBar
import com.belyakov.testproject.newsdetail.presentation.composable.NewsDetailedText
import com.belyakov.testproject.newsdetail.presentation.composable.NewsDetailedTop

class NewsDetailDestination(newsId: String) : TestNewsDestination(
    route = "newsdetail/${newsId.encodeUrl()}"
)

@Composable
fun NewsDetailScreen(
    onNavigate: (NavigationCommand) -> Unit,
    viewModel: NewsDetailViewModel = hiltViewModel()
) {
    val news = viewModel.state.value

    if (news != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .testTag("NewsDetailScreen")
        ) {
            NewsDetailedAppBar(
                title = news.title,
                onBackClick = { onNavigate(NavigationCommand.NavigateBack) }
            )
            NewsDetailedTop(newsModel = news)
            NewsDetailedText(text = news.content)
        }
    }
}

@Preview
@Composable
fun NewsDetailScreenPreview() {
    NewsDetailScreen(
        onNavigate = {}
    )
}