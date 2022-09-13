package com.belyakov.testproject.filter.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.belyakov.testproject.R
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.filter.presentation.composable.FilterItem
import com.belyakov.testproject.filter.presentation.composable.FilterTitleItem

object NewsFilterDestination : TestNewsDestination(route = "newsfilter")

@Composable
fun NewsFilterDialog(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: NewsFilterViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Dialog(onDismissRequest = onBackClick) {
        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = modifier
        ) {
            Box {
                Column(
                    modifier = Modifier
                        .padding(bottom = 60.dp) // todo 60 вынести
                        .verticalScroll(rememberScrollState())
                ) {
                    FilterTitleItem(title = stringResource(R.string.filter_category_title))
                    state.categoryFilters.forEach { filter ->
                        FilterItem(
                            title = filter.title,
                            isChecked = false, // todo
                            onClicked = { }
                        )
                    }
                    FilterTitleItem(title = stringResource(R.string.filter_country_title))
                    state.countryFilters.forEach { filter ->
                        FilterItem(
                            title = filter.title,
                            isChecked = false, // todo
                            onClicked = { }
                        )
                    }
                }
                Text(
                    text = stringResource(R.string.filter_dialog_confirm),
                    style = MaterialTheme.typography.button,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(MaterialTheme.colors.primary)
                        .clickable { onBackClick() }
                        .padding(vertical = 12.dp)
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