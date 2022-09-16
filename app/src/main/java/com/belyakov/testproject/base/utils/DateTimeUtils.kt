package com.belyakov.testproject.base.utils

import org.threeten.bp.DateTimeException
import org.threeten.bp.ZonedDateTime

fun String.parseZonedDateTimeOrDefault(
    default: ZonedDateTime = ZonedDateTime.now()
): ZonedDateTime {

    return try {
        ZonedDateTime.parse(this)
    } catch (e: DateTimeException) {
        default
    }
}