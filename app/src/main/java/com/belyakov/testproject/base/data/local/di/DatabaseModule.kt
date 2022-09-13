package com.belyakov.testproject.base.data.local.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.belyakov.testproject.base.data.local.TestNewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TestNewsDatabase {
        return Room.databaseBuilder(
            context,
            TestNewsDatabase::class.java,
            TestNewsDatabase.DATABASE_NAME
        ).build()
    }
}