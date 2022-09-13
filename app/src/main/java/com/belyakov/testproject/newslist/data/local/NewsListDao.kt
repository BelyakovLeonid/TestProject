package com.belyakov.testproject.newslist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.belyakov.testproject.newslist.data.local.model.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsEntity>)

    @Query("SELECT * FROM ${NewsEntity.TABLE_NAME}")
    fun getNewsAsFlow(): Flow<List<NewsEntity>>

    @Query("DELETE FROM ${NewsEntity.TABLE_NAME}")
    suspend fun clear()
}