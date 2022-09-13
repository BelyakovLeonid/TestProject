package com.belyakov.testproject.newslist.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.belyakov.testproject.newslist.data.local.converter.LocalDateConverter
import org.threeten.bp.LocalDate

@Entity(tableName = NewsEntity.TABLE_NAME)
@TypeConverters(LocalDateConverter::class)
class NewsEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val imageUrl: String?,
    val publishedAt: LocalDate,
    val source: String,
    val content: String
) {
    companion object {
        const val TABLE_NAME = "news"
    }
}