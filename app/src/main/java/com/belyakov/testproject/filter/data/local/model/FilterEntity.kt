package com.belyakov.testproject.filter.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = FilterEntity.TABLE_NAME)
data class FilterEntity(
    @PrimaryKey
    val id: String,
    val value: String?
) {

    companion object {
        const val TABLE_NAME = "filter"
    }
}