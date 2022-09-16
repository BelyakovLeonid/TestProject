package com.belyakov.testproject.base.presentation.navigation

open class TestNewsDestination(val route: String)

sealed interface NavigationCommand {
    object NavigateBack : NavigationCommand

    class NavigateToDestination(
        val destination: TestNewsDestination
    ) : NavigationCommand
}
