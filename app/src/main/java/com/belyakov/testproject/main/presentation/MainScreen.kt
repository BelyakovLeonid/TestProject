package com.belyakov.testproject.main.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import com.belyakov.testproject.R
import com.belyakov.testproject.main.presentation.composables.NewsList
import com.belyakov.testproject.main.presentation.composables.getFakeNewsModel

@Composable
fun MainScreen(
    //    viewModel: MainViewModel by viewModel
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(
                    text = stringResource(id = R.string.main_screen_title),
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.align(Alignment.Center)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FilterAlt,
                        contentDescription = stringResource(R.string.main_screen_filter)
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
        NewsList(
            news = listOf(
                getFakeNewsModel(1),
                getFakeNewsModel(2),
                getFakeNewsModel(3),
                getFakeNewsModel(4),
                getFakeNewsModel(5),
                getFakeNewsModel(6),
                getFakeNewsModel(7)
            ),
            onNewsClick = {} //viewModel::onNewsClick
        )
    }
}