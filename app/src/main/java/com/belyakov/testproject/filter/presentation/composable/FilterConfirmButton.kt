package com.belyakov.testproject.filter.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.belyakov.testproject.R

@Composable
fun FilterConfirmButton(
    onConfirmClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Text(
        text = stringResource(R.string.filter_dialog_confirm),
        style = MaterialTheme.typography.button,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.onPrimary,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.filter_button_height))
            .background(MaterialTheme.colors.primary)
            .clickable { onConfirmClicked() }
            .padding(vertical = dimensionResource(R.dimen.margin_regular))
            .wrapContentHeight(align = Alignment.CenterVertically)
    )
}

@Preview
@Composable
fun FilterConfirmButtonPreview() {
    FilterConfirmButton(
        onConfirmClicked = {}
    )
}