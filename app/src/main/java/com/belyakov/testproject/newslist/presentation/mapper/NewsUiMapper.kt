package com.belyakov.testproject.newslist.presentation.mapper

import com.belyakov.testproject.R
import com.belyakov.testproject.base.domain.repository.ResourceRepository
import com.belyakov.testproject.newslist.domain.model.NewsModel
import com.belyakov.testproject.newslist.presentation.model.NewsUiModel
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.temporal.ChronoUnit
import javax.inject.Inject

class NewsUiMapper @Inject constructor(
    private val resourceRepository: ResourceRepository
) {

    fun map(model: NewsModel): NewsUiModel {
        return NewsUiModel(
            id = model.id,
            title = model.title,
            source = model.source,
            date = formatPublishDate(model.publishedAt),
            imageUrl = model.imageUrl,
            content = model.content
        )
    }

    private fun formatPublishDate(date: ZonedDateTime): String {
        val today = ZonedDateTime.now()
        val passedMinutes = date.until(today, ChronoUnit.MINUTES)

        return when {
            passedMinutes < ChronoUnit.HOURS.duration.toMinutes() -> {
                resourceRepository.getQuantityString(
                    R.plurals.news_minutes_before,
                    passedMinutes.toInt()
                )
            }
            passedMinutes < ChronoUnit.DAYS.duration.toMinutes() -> {
                resourceRepository.getQuantityString(
                    R.plurals.news_hours_before,
                    (passedMinutes / ChronoUnit.HOURS.duration.toMinutes()).toInt()
                )
            }
            passedMinutes < ChronoUnit.YEARS.duration.toMinutes() -> {
                resourceRepository.getQuantityString(
                    R.plurals.news_days_before,
                    (passedMinutes / ChronoUnit.DAYS.duration.toMinutes()).toInt()
                )
            }
            else -> {
                resourceRepository.getQuantityString(
                    R.plurals.news_years_before,
                    (passedMinutes / ChronoUnit.YEARS.duration.toMinutes()).toInt()
                )
            }
        }
    }
}