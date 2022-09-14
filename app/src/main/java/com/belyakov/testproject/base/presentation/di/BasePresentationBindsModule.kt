package com.belyakov.testproject.base.presentation.di

import com.belyakov.testproject.base.presentation.navigation.TestNewsNavigator
import com.belyakov.testproject.base.presentation.navigation.TestNewsNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BasePresentationBindsModule {

    @Binds
    fun bindsNavigator(impl: TestNewsNavigatorImpl): TestNewsNavigator
}