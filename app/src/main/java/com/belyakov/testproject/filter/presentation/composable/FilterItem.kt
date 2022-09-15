package com.belyakov.testproject.filter.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.belyakov.testproject.R

@Composable
fun FilterItem(
    title: String,
    isChecked: Boolean,
    onClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.filter_button_height))
            .clickable { onClicked() }
            .padding(all = dimensionResource(R.dimen.margin_regular))
    ) {
        Text(
            text = title,
        )
        if (isChecked) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = stringResource(R.string.filter_item_checked),
                tint = MaterialTheme.colors.primary,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.filter_item_icon_size))
                    .padding(start = dimensionResource(R.dimen.margin_regular))
            )
        }
    }
}

@Preview
@Composable
fun FilterItemPreview() {
    FilterItem(
        title = "Africa",
        isChecked = true,
        onClicked = {}
    )
}