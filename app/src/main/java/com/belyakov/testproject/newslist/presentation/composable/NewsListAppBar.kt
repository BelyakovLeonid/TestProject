package com.belyakov.testproject.newslist.presentation.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belyakov.testproject.R

@Composable
fun NewsListAppBar(
    onNavigateToFilter: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(modifier = modifier) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = stringResource(id = R.string.news_list_screen_title),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.align(Alignment.Center)
            )
            IconButton(
                onClick = onNavigateToFilter,
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(
                    imageVector = Icons.Outlined.FilterAlt,
                    contentDescription = stringResource(R.string.news_list_screen_filter)
                )
                Canvas(
                    modifier = Modifier
                        .size(10.dp)
                        .align(Alignment.TopEnd),
                    onDraw = {
                        drawCircle(color = Color.Red)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun NewsListAppBarPreview() {
    NewsListAppBar(
        onNavigateToFilter = {}
    )
}