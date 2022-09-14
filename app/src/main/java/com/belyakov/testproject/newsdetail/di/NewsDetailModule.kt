package com.belyakov.testproject.newsdetail.di

import com.belyakov.testproject.base.data.local.TestNewsDatabase
import com.belyakov.testproject.newsdetail.data.NewsDetailRepositoryImpl
import com.belyakov.testproject.newsdetail.data.local.NewsDetailDao
import com.belyakov.testproject.newsdetail.domain.repository.NewsDetailRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module(includes = [NewsDetailModule.NewsDetailBindsModule::class])
@InstallIn(ViewModelComponent::class)
object NewsDetailModule {

    @Provides
    fun provideDao(database: TestNewsDatabase): NewsDetailDao {
        return database.getNewsDetailDao()
    }

    @Module
    @InstallIn(ViewModelComponent::class)
    interface NewsDetailBindsModule {

        @Binds
        fun bindsRepository(impl: NewsDetailRepositoryImpl): NewsDetailRepository
    }
}
