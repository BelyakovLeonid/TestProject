package com.belyakov.testproject.base.data.remote.di

import com.belyakov.testproject.base.data.remote.interceptor.ApiKeyInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

private const val BASE_URL = "https://newsapi.org/v2/"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .build()
    }

    @Provides
    fun provideOkHttpClient(
        interceptors: Set<@JvmSuppressWildcards Interceptor>
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        interceptors.forEach { builder.addInterceptor(it) }
        return builder.build()
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface NetworkBindModule{

        @Binds
        @IntoSet
        fun bindApiKeyInterceptor(impl: ApiKeyInterceptor): Interceptor
    }
}