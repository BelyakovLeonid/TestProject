package com.belyakov.testproject.newsdetail.data.local

import androidx.room.Dao
import androidx.room.Query
import com.belyakov.testproject.newslist.data.local.model.NewsEntity

@Dao
interface NewsDetailDao {

    @Query("SELECT * FROM ${NewsEntity.TABLE_NAME} WHERE id =:id")
    suspend fun getNewsById(id: String): NewsEntity
}