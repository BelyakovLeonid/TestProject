package com.belyakov.testproject.newslist.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.belyakov.testproject.newslist.data.local.converter.ZonedDateTimeConverter
import org.threeten.bp.ZonedDateTime

@Entity(tableName = NewsEntity.TABLE_NAME)
@TypeConverters(ZonedDateTimeConverter::class)
data class NewsEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val imageUrl: String?,
    val publishedAt: ZonedDateTime,
    val source: String?,
    val content: String
) {
    companion object {
        const val TABLE_NAME = "news"
    }
}