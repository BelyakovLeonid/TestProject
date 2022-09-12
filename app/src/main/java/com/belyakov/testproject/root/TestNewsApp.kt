package com.belyakov.testproject.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.belyakov.testproject.base.presentation.theme.TestNewsTheme
import com.belyakov.testproject.filter.presentation.NewsFilterDestination
import com.belyakov.testproject.filter.presentation.NewsFilterDialog
import com.belyakov.testproject.newsdetail.presentation.NewsDetailDestination
import com.belyakov.testproject.newsdetail.presentation.NewsDetailScreen
import com.belyakov.testproject.newslist.presentation.NewsListDestination
import com.belyakov.testproject.newslist.presentation.NewsListScreen

@Composable
fun TestNewsApp(
    modifier: Modifier = Modifier,
    appState: TestNewsAppState = rememberTestNewsAppState()
) {

    TestNewsTheme {
        NavHost(
            modifier = modifier,
            navController = appState.navController,
            startDestination = appState.startDestination
        ) {
            composable(route = NewsListDestination.route) {
                NewsListScreen(
                    onNavigateToDetails = appState::onNavigate,
                    onNavigateToFilter = appState::onNavigate
                )
            }
            composable(route = NewsDetailDestination.route) {
                NewsDetailScreen(
                    onBackClick = appState::onBackClick
                )
            }
            dialog(route = NewsFilterDestination.route){
                NewsFilterDialog(
                    onBackClick = appState::onBackClick
                )
            }
        }
    }
}