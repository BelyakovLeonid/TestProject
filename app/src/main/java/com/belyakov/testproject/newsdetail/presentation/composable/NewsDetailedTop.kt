package com.belyakov.testproject.newsdetail.presentation.composable

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
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.belyakov.testproject.R
import com.belyakov.testproject.base.presentation.theme.Cyan100
import com.belyakov.testproject.base.presentation.theme.Gray300
import com.belyakov.testproject.base.presentation.theme.Gray500
import com.belyakov.testproject.newslist.presentation.composable.getFakeNewsModel
import com.belyakov.testproject.newslist.presentation.model.NewsUiModel

@Composable
fun NewsDetailedTop(
    newsModel: NewsUiModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .heightIn(min = dimensionResource(R.dimen.news_detail_top_height))
    ) {
        AsyncImage(
            model = newsModel.imageUrl,
            placeholder = ColorPainter(Gray300),
            error = ColorPainter(Gray300),
            fallback = ColorPainter(Gray300),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .height(dimensionResource(R.dimen.news_detail_image_height))
                .fillMaxWidth()
        )
        Card(
            elevation = dimensionResource(R.dimen.elevation_regular),
            shape = RoundedCornerShape(dimensionResource(R.dimen.corner_regular)),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = dimensionResource(R.dimen.margin_regular))
                .heightIn(min = dimensionResource(R.dimen.news_detail_description_height))
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(all = dimensionResource(R.dimen.margin_regular))
            ) {
                Text(
                    text = newsModel.title,
                    style = MaterialTheme.typography.h6
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.margin_regular))
                        .fillMaxWidth()
                ) {
                    Text(
                        text = newsModel.date,
                        style = MaterialTheme.typography.body2,
                        color = Gray500
                    )
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

@Preview
@Composable
fun NewsDetailedTopPreview() {
    NewsDetailedTop(
        getFakeNewsModel(0),
        modifier = Modifier,
    )
}