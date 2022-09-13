package com.belyakov.testproject.newslist.di

import com.belyakov.testproject.newslist.data.NewsListRepositoryImpl
import com.belyakov.testproject.newslist.data.remote.NewsListApi
import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [NewsListModule.NewsListBindModule::class])
@InstallIn(ViewModelComponent::class)
object NewsListModule {

    @Provides
    fun providesApi(retrofit: Retrofit): NewsListApi {
        return retrofit.create()
    }

    @Module
    @InstallIn(ViewModelComponent::class)
    interface NewsListBindModule{

        @Binds
        fun bindRepository(impl: NewsListRepositoryImpl): NewsListRepository
    }
}