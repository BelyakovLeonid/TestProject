package com.belyakov.testproject.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.belyakov.testproject.base.presentation.navigation.NavigationCommand
import com.belyakov.testproject.base.presentation.navigation.TestNewsDestination
import com.belyakov.testproject.newslist.presentation.NewsListDestination

@Stable
class TestNewsAppState(
    val navController: NavHostController
) {

    val startDestination = NewsListDestination.route

    fun onNavigate(command: NavigationCommand) {
        when(command){
            is NavigationCommand.NavigateBack -> navController.popBackStack()
            is  NavigationCommand.NavigateToDestination -> navController.navigate(command.destination.route)
        }
    }
}

@Composable
fun rememberTestNewsAppState(
    navController: NavHostController = rememberNavController()
): TestNewsAppState = remember(navController) {
    TestNewsAppState(navController)
}