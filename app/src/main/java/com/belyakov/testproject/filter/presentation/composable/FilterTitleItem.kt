package com.belyakov.testproject.filter.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.belyakov.testproject.R

@Composable
fun FilterTitleItem(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
            .padding(all = dimensionResource(R.dimen.margin_regular))
    )
}

@Preview
@Composable
fun FilterTitleItemPreview() {
    FilterTitleItem(
        title = "Choose Country"
    )
}