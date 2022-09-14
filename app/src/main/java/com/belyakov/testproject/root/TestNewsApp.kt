package com.belyakov.testproject.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import com.belyakov.testproject.base.presentation.theme.TestNewsTheme
import com.belyakov.testproject.filter.presentation.NewsFilterDestination
import com.belyakov.testproject.filter.presentation.NewsFilterDialog
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
                    onNavigate = appState::onNavigate
                )
            }
            composable(
                route = "newsdetail/{newsId}",
                arguments = listOf(navArgument("newsId") { type = NavType.StringType })
            ) {
                NewsDetailScreen(
                    onNavigate = appState::onNavigate
                )
            }
            dialog(route = NewsFilterDestination.route) {
                NewsFilterDialog(
                    onNavigate = appState::onNavigate
                )
            }
        }
    }
}