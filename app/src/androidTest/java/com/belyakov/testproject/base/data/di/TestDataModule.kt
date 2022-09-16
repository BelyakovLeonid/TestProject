package com.belyakov.testproject.base.data.di

import android.content.Context
import androidx.room.Room
import com.belyakov.testproject.base.data.local.ResourceRepositoryImpl
import com.belyakov.testproject.base.data.local.TestNewsDatabase
import com.belyakov.testproject.base.data.local.di.DataModule
import com.belyakov.testproject.base.domain.repository.ResourceRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module(includes = [TestDataModule.DataBindsModule::class])
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
object TestDataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TestNewsDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            TestNewsDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @Module
    @TestInstallIn(
        components = [SingletonComponent::class],
        replaces = [DataModule.DataBindsModule::class]
    )
    interface DataBindsModule {

        @Binds
        fun bindResourceRepository(impl: ResourceRepositoryImpl): ResourceRepository
    }
}