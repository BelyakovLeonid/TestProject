package com.belyakov.testproject.detail.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.belyakov.testproject.base.presentation.theme.Cyan100
import com.belyakov.testproject.base.presentation.theme.Gray500
import com.belyakov.testproject.main.presentation.composable.getFakeNewsModel
import com.belyakov.testproject.main.presentation.model.NewsUiModel

@Composable
fun NewsDetailedTop(
    newsModel: NewsUiModel,
    modifier: Modifier
) {
    Box(modifier = modifier.height(360.dp)) {
        AsyncImage(
            model = newsModel.imageUrl,
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
        )
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp)
                .heightIn(min = 120.dp)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = newsModel.title,
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
fun NewsDetailedTopPreview() {
    NewsDetailedTop(
        getFakeNewsModel(0),
        modifier = Modifier,
    )
}