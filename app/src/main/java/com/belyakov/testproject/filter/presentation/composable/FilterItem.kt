package com.belyakov.testproject.filter.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            .clickable { onClicked() }
            .padding(12.dp)
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
                    .size(30.dp)
                    .padding(start = 12.dp)
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