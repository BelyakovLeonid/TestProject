package com.belyakov.testproject.newslist.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.belyakov.testproject.R

@Composable
fun NewsListAlertWithButton(
    title: String,
    buttonText: String,
    onButtonCLick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_regular)))
        Button(onClick = onButtonCLick) {
            Text(
                text = buttonText.uppercase(),
                style = MaterialTheme.typography.button
            )
        }
    }
}

@Preview
@Composable
fun NewsListAlertWithButtonPreview() {
    NewsListAlertWithButton(
        title = "Just test",
        buttonText = "Just test button",
        onButtonCLick = {}
    )
}