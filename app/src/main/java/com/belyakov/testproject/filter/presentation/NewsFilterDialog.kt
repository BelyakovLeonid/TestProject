package com.belyakov.testproject.filter.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.belyakov.testproject.R
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.filter.presentation.composable.FilterItem
import com.belyakov.testproject.filter.presentation.composable.FilterTitleItem
import com.belyakov.testproject.filter.presentation.composable.FilterConfirmButton

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
                            isChecked = state.selectedCategory == filter,
                            onClicked = { viewModel.onCategoryClicked(filter) }
                        )
                    }
                    FilterTitleItem(title = stringResource(R.string.filter_country_title))
                    state.countryFilters.forEach { filter ->
                        FilterItem(
                            title = filter.title,
                            isChecked = state.selectedCountry == filter,
                            onClicked = { viewModel.onCountryClicked(filter) }
                        )
                    }
                }
                FilterConfirmButton(
                    onConfirmClicked = { onBackClick() },
                    modifier = Modifier.align(Alignment.BottomCenter)
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