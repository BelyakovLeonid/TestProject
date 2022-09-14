package com.belyakov.testproject.base.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.belyakov.testproject.base.presentation.navigation.NavigationCommand
import com.belyakov.testproject.base.presentation.navigation.TestNewsNavigator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun SubscribeToNavigationCommands(
    navigator: TestNewsNavigator,
    onNavigate: (NavigationCommand) -> Unit
) {
    LaunchedEffect(Unit) {
        navigator.navigationCommand.onEach {
            onNavigate(it)
        }.launchIn(this)
    }
}