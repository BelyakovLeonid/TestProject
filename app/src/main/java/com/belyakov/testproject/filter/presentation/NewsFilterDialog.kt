package com.belyakov.testproject.filter.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.belyakov.testproject.R
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination

object NewsFilterDestination : TestNewsDestination(route = "newsfilter")

@Composable
fun NewsFilterDialog(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onBackClick) {
        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = modifier
        ) {
            Column {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    text = "America",
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    text = "America2",
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    text = "America3",
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.primary)
                        .clickable { }
                        .padding(vertical = 12.dp),
                    text = stringResource(id = R.string.filter_dialog_confirm),
                )
            }
        }
    }
}

@Preview
@Composable
fun NewsFilterDialogPreview() {
    NewsFilterDialog(
        onBackClick = {}
    )
}