package com.belyakov.testproject.main.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belyakov.testproject.main.presentation.model.NewsUiModel

@Composable
fun NewsList(
    news: List<NewsUiModel>,
    onNewsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(
            items = news,
            key = { item -> item.id }
        ) { item ->
            NewsItem(
                newsModel = item,
                onNewsClick = onNewsClick
            )
        }
    }
}

fun getFakeNewsModel(id: Int = 1) = NewsUiModel(
    id = id,
    title = "This news is fake, do not trust it please. This news is fake, do not trust it please.",
    author = "CNN",
    date = "1 day ago",
    imageUrl = "https://ibb.co/TtRWp9j",
)

@Preview
@Composable
fun NewsListPreview() {
    NewsList(
        news = listOf(getFakeNewsModel(1), getFakeNewsModel(2), getFakeNewsModel(3)),
        modifier = Modifier,
        onNewsClick = {}
    )
}