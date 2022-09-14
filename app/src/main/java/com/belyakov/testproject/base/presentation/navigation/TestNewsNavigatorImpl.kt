package com.belyakov.testproject.base.presentation.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class TestNewsNavigatorImpl @Inject constructor() : TestNewsNavigator {

    private val _navigationCommand = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = 1)
    override val navigationCommand = _navigationCommand.asSharedFlow()

    override fun navigateTo(destination: TestNewsDestination) {
        _navigationCommand.tryEmit(NavigationCommand.NavigateToDestination(destination))
    }
}