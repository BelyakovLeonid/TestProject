package com.belyakov.testproject.main.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belyakov.testproject.R
import com.belyakov.testproject.base.presentation.theme.Cyan100
import com.belyakov.testproject.base.presentation.theme.Gray500
import com.belyakov.testproject.main.presentation.model.NewsUiModel

@Composable
fun NewsItem(
    newsModel: NewsUiModel,
    onNewsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val itemHeight = 120.dp

    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier.clickable { onNewsClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight)
        ) {
            Image(
                painter = painterResource(id = R.drawable.test_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(itemHeight)
                    .width(itemHeight)
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
                    Text(
                        text = newsModel.author,
                        style = MaterialTheme.typography.body2,
                        color = Cyan100
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun NewsItemPreview() {
    val fakeNewsModel = NewsUiModel(
        id = 1,
        title = "This news is fake, do not trust it please. This news is fake, do not trust it please.",
        author = "CNN",
        date = "1 day ago",
        imageUrl = "",
    )

    NewsItem(
        newsModel = fakeNewsModel,
        modifier = Modifier,
        onNewsClick = {}
    )
}