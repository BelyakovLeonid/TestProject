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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.belyakov.testproject.R
import com.belyakov.testproject.base.presentation.navigation.NavigationCommand
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.base.utils.SubscribeToNavigationCommands
import com.belyakov.testproject.filter.presentation.composable.FilterConfirmButton
import com.belyakov.testproject.filter.presentation.composable.FilterItem
import com.belyakov.testproject.filter.presentation.composable.FilterTitleItem

object NewsFilterDestination : TestNewsDestination(route = "newsfilter")

@Composable
fun NewsFilterDialog(
    onNavigate: (NavigationCommand) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: NewsFilterViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    SubscribeToNavigationCommands(
        navigator = viewModel,
        onNavigate = onNavigate
    )

    Dialog(onDismissRequest = viewModel::onDismiss) {
        Card(
            shape = RoundedCornerShape(dimensionResource(R.dimen.corner_huge)),
            modifier = modifier
        ) {
            Box {
                Column(
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.filter_button_height))
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
                    onConfirmClicked = { viewModel.onConfirmClicked() },
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
        onNavigate = {}
    )
}