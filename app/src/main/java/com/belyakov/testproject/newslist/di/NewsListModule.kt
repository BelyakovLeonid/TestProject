package com.belyakov.testproject.newslist.di

import com.belyakov.testproject.base.data.local.TestNewsDatabase
import com.belyakov.testproject.newslist.data.NewsListRepositoryImpl
import com.belyakov.testproject.newslist.data.local.NewsListDao
import com.belyakov.testproject.newslist.data.remote.NewsListApi
import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module(includes = [NewsListModule.NewsListBindModule::class])
@InstallIn(ViewModelComponent::class)
object NewsListModule {

    @Provides
    fun providesApi(retrofit: Retrofit): NewsListApi {
        return retrofit.create()
    }

    @Provides
    fun providesDao(database: TestNewsDatabase): NewsListDao {
        return database.getNewsListDao()
    }

    @Module
    @InstallIn(ViewModelComponent::class)
    interface NewsListBindModule {

        @Binds
        @ViewModelScoped
        fun bindRepository(impl: NewsListRepositoryImpl): NewsListRepository
    }
}