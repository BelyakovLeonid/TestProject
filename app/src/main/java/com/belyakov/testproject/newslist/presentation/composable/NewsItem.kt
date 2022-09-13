package com.belyakov.testproject.newslist.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.belyakov.testproject.base.presentation.theme.Cyan100
import com.belyakov.testproject.base.presentation.theme.Gray500
import com.belyakov.testproject.newslist.presentation.model.NewsUiModel

@Composable
fun NewsItem(
    newsModel: NewsUiModel,
    onNewsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val itemHeight = 120.dp

    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight)
                .clickable { onNewsClick() }
        ) {
            AsyncImage(
                model = newsModel.imageUrl,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(itemHeight),
                contentDescription = null
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(12.dp)
            ) {
                Text(
                    text = newsModel.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = newsModel.date,
                        style = MaterialTheme.typography.body2,
                        color = Gray500
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = newsModel.source,
                        style = MaterialTheme.typography.body2,
                        color = Cyan100
                    )
                }
            }
        }
    }
}

@Preview(locale = "en")
@Composable
fun NewsItemPreview() {
    NewsItem(
        newsModel = getFakeNewsModel(),
        modifier = Modifier,
        onNewsClick = {}
    )
}

@Preview(locale = "ar")
@Composable
fun NewsItemRTLPreview() {
    NewsItem(
        newsModel = getFakeNewsModel(),
        modifier = Modifier,
        onNewsClick = {}
    )
}