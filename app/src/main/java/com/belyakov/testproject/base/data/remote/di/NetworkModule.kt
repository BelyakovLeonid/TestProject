package com.belyakov.testproject.base.data.remote.di

import com.belyakov.testproject.base.data.remote.interceptor.ApiKeyInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

private const val BASE_URL = "https://newsapi.org/v2/"

@Module(includes = [NetworkModule.NetworkBindModule::class])
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(converterFactory)
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

    @Provides
    @OptIn(ExperimentalSerializationApi::class)
    fun provideConverterFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        return Json.asConverterFactory(contentType)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface NetworkBindModule {

        @Binds
        @IntoSet
        fun bindApiKeyInterceptor(impl: ApiKeyInterceptor): Interceptor
    }
}