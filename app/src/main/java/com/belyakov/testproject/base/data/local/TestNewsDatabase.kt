package com.belyakov.testproject.base.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.belyakov.testproject.filter.data.local.FilterDao
import com.belyakov.testproject.filter.data.local.model.FilterEntity
import com.belyakov.testproject.newsdetail.data.local.NewsDetailDao
import com.belyakov.testproject.newslist.data.local.NewsListDao
import com.belyakov.testproject.newslist.data.local.model.NewsEntity

@Database(
    version = TestNewsDatabase.VERSION,
    entities = [
        NewsEntity::class,
        FilterEntity::class
    ]
)
abstract class TestNewsDatabase : RoomDatabase() {

    abstract fun getNewsListDao(): NewsListDao
    abstract fun getNewsDetailDao(): NewsDetailDao
    abstract fun getFilterDao(): FilterDao

    companion object {
        const val VERSION = 1
        const val DATABASE_NAME = "com.biot.database"
    }
}