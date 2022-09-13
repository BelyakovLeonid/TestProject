package com.belyakov.testproject.base.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.belyakov.testproject.newslist.data.local.NewsListDao
import com.belyakov.testproject.newslist.data.local.model.NewsEntity

@Database(
    version = TestNewsDatabase.VERSION,
    entities = [NewsEntity::class]
)
abstract class TestNewsDatabase : RoomDatabase() {

    abstract fun getNewsListDao(): NewsListDao

    companion object {
        const val VERSION = 1
        const val DATABASE_NAME = "com.biot.database"
    }
}