package com.belyakov.testproject.base.data.local.di

import android.content.Context
import androidx.room.Room
import com.belyakov.testproject.base.data.local.ResourceRepositoryImpl
import com.belyakov.testproject.base.data.local.TestNewsDatabase
import com.belyakov.testproject.base.domain.repository.ResourceRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [DataModule.DataBindsModule::class])
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TestNewsDatabase {
        return Room.databaseBuilder(
            context,
            TestNewsDatabase::class.java,
            TestNewsDatabase.DATABASE_NAME
        ).build()
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DataBindsModule {

        @Binds
        fun bindResourceRepository(impl: ResourceRepositoryImpl): ResourceRepository
    }
}