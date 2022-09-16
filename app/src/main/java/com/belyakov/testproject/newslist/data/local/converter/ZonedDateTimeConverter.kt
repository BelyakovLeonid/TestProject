package com.belyakov.testproject.newslist.data.local.converter

import androidx.room.TypeConverter
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

class ZonedDateTimeConverter {

    @TypeConverter
    fun save(value: ZonedDateTime): String {
        return value.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
    }

    @TypeConverter
    fun restore(value: String): ZonedDateTime {
        return ZonedDateTime.parse(value, DateTimeFormatter.ISO_ZONED_DATE_TIME)
    }
}