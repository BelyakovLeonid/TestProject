package com.belyakov.testproject.filter.di

import com.belyakov.testproject.base.data.local.TestNewsDatabase
import com.belyakov.testproject.filter.data.FilterRepositoryImpl
import com.belyakov.testproject.filter.data.local.FilterDao
import com.belyakov.testproject.filter.domain.repository.FilterRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module(includes = [FilterModule.FilterBindsModule::class])
@InstallIn(ViewModelComponent::class)
object FilterModule {

    @Provides
    fun provideFilterDao(database: TestNewsDatabase): FilterDao {
        return database.getFilterDao()
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface FilterBindsModule {

        @Binds
        fun bindsFilterRepository(impl: FilterRepositoryImpl): FilterRepository
    }
}