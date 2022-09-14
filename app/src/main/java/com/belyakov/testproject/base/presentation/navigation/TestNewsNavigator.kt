package com.belyakov.testproject.base.presentation.navigation

import kotlinx.coroutines.flow.SharedFlow

interface TestNewsNavigator {
    val navigationCommand: SharedFlow<NavigationCommand>

    fun navigateTo(destination: TestNewsDestination)
}