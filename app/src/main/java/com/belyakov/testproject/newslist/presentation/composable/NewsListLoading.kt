package com.belyakov.testproject.newslist.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NewsListLoading(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxWidth(0.15f)
                .aspectRatio(1.0f)
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun NewsListLoadingPreview() {
    NewsListLoading(
        modifier = Modifier
    )
}