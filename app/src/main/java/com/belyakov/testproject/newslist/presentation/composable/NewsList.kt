package com.belyakov.testproject.newslist.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belyakov.testproject.newslist.presentation.model.NewsUiModel

@Composable
fun NewsList(
    news: List<NewsUiModel>,
    onNewsClick: (String) -> Unit,
    onShowItemAtPosition: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp)
    ) {
        itemsIndexed(
            items = news,
            key = { _, item -> item.id }
        ) { index, item ->
            onShowItemAtPosition(index)
            NewsItem(
                newsModel = item,
                onNewsClick = { onNewsClick(item.id) }
            )
        }
    }
}

//todo
fun getFakeNewsModel(id: Int = 1) = NewsUiModel(
    id = "id",
    title = "This news is fake, do not trust it please. This news is fake, do not trust it please.",
    source = "CNN",
    date = "1 day ago",
    imageUrl = "https://i.ibb.co/qp9JXTq/test-image.jpg",
    content = "This news is fake, do not trust it please. This news is fake, do not trust it please."
)

@Preview
@Composable
fun NewsListPreview() {
    NewsList(
        news = listOf(getFakeNewsModel(1), getFakeNewsModel(2), getFakeNewsModel(3)),
        modifier = Modifier,
        onNewsClick = {},
        onShowItemAtPosition = {}
    )
}