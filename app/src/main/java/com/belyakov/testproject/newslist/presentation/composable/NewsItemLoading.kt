package com.belyakov.testproject.newslist.presentation.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belyakov.testproject.R

@Composable
fun NewsItemLoading(
    modifier: Modifier = Modifier
) {

    Text(
        text = stringResource(R.string.news_list_page_loading),
        style = MaterialTheme.typography.subtitle2,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    )
}

@Preview
@Composable
fun NewsItemLoadingPreview() {
    NewsItemLoading()
}