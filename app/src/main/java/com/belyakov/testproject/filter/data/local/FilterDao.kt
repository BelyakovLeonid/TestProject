package com.belyakov.testproject.filter.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.belyakov.testproject.filter.data.local.model.FilterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(filter: FilterEntity)

    @Query("SELECT * FROM ${FilterEntity.TABLE_NAME} WHERE id = :id")
    suspend fun getFilterById(id: String): FilterEntity?

    @Query("SELECT * FROM ${FilterEntity.TABLE_NAME} WHERE id = :id")
    fun getFilterByIdAsFlow(id: String): Flow<FilterEntity?>

    @Query("DELETE FROM ${FilterEntity.TABLE_NAME}")
    suspend fun clear()
}