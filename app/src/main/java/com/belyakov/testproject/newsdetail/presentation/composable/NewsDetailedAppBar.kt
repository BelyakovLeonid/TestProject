package com.belyakov.testproject.newsdetail.presentation.composable

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.belyakov.testproject.R

@Composable
fun NewsDetailedAppBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(modifier = modifier) {
        IconButton(
            onClick = { onBackClick() },
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.detailed_screen_back)
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun NewsDetailedPreview() {
    NewsDetailedAppBar(
        title = "Very long test title.Very long test title.Very long test title.",
        onBackClick = {}
    )
}