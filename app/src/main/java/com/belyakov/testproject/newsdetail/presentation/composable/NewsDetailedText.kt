package com.belyakov.testproject.newsdetail.presentation.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.belyakov.testproject.R
import com.belyakov.testproject.base.presentation.theme.Gray500
import com.belyakov.testproject.newslist.presentation.composable.getFakeNewsModel

@Composable
fun NewsDetailedText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        color = Gray500,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.margin_regular),
                vertical = dimensionResource(R.dimen.margin_huge)
            )
    )
}

@Preview
@Composable
fun NewsDetailedTextPreview() {
    NewsDetailedText(
        text = getFakeNewsModel().title
    )
}