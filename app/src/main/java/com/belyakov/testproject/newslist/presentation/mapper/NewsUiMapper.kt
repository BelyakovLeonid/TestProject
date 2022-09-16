package com.belyakov.testproject.newslist.presentation.mapper

import androidx.annotation.VisibleForTesting
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
            source = model.source ?: resourceRepository.getString(R.string.news_list_unknown),
            date = formatPublishDate(model.publishedAt),
            imageUrl = model.imageUrl,
            content = model.content
        )
    }

    @VisibleForTesting
    fun formatPublishDate(date: ZonedDateTime): String {
        val today = ZonedDateTime.now()
        val passedMinutes = date.until(today, ChronoUnit.MINUTES)

        return when {
            passedMinutes == 0L -> {
                resourceRepository.getString(R.string.news_recently)
            }
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