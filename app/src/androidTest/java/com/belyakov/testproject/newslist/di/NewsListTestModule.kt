package com.belyakov.testproject.newslist.di

import com.belyakov.testproject.base.data.local.TestNewsDatabase
import com.belyakov.testproject.newslist.data.NewsListRepositoryImpl
import com.belyakov.testproject.newslist.data.local.NewsListDao
import com.belyakov.testproject.newslist.data.remote.FakeNewsListApi
import com.belyakov.testproject.newslist.data.remote.NewsListApi
import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.testing.TestInstallIn

@Module(includes = [NewsListTestModule.NewsListBindModule::class])
@TestInstallIn(
    components = [ViewModelComponent::class],
    replaces = [NewsListModule::class]
)
object NewsListTestModule {

    @Provides
    fun providesApi(): NewsListApi {
        return FakeNewsListApi()
    }

    @Provides
    fun providesDao(database: TestNewsDatabase): NewsListDao {
        return database.getNewsListDao()
    }

    @Module
    @TestInstallIn(
        components = [ViewModelComponent::class],
        replaces = [NewsListModule.NewsListBindModule::class]
    )
    interface NewsListBindModule {

        @Binds
        @ViewModelScoped
        fun bindRepository(impl: NewsListRepositoryImpl): NewsListRepository
    }
}