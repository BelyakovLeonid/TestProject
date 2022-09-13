package com.belyakov.testproject.newslist.data.mapper

import com.belyakov.testproject.R
import com.belyakov.testproject.base.domain.repository.ResourceRepository
import com.belyakov.testproject.base.utils.parseZonedDateTimeOrDefault
import com.belyakov.testproject.newslist.data.local.model.NewsEntity
import com.belyakov.testproject.newslist.data.remote.model.NewsDto
import com.belyakov.testproject.newslist.data.remote.model.NewsListDto
import com.belyakov.testproject.newslist.domain.model.NewsModel
import org.threeten.bp.LocalDate
import javax.inject.Inject

class NewsDataMapper @Inject constructor(
    private val resourceRepository: ResourceRepository
) {

    fun map(entity: NewsEntity): NewsModel {
        return NewsModel(
            id = entity.id,
            title = entity.title,
            imageUrl = entity.imageUrl,
            publishedAt = entity.publishedAt,
            source = entity.source,
            content = entity.content,
        )
    }

    fun map(dto: NewsListDto): List<NewsEntity> {
        return dto.articles.mapNotNull(::map)
    }

    private fun map(newsDto: NewsDto): NewsEntity? {
        if (newsDto.content == null ||
            newsDto.title == null ||
            newsDto.url == null
        ) return null

        return NewsEntity(
            id = newsDto.url,
            title = newsDto.title,
            imageUrl = newsDto.urlToImage,
            publishedAt = parsePublishDate(newsDto.publishedAt),
            source = newsDto.source?.name ?: resourceRepository.getString(R.string.news_list_unknown),
            content = newsDto.content,
        )
    }

    private fun parsePublishDate(publishedAt: String?): LocalDate {
        return if (publishedAt == null) {
            LocalDate.now()
        } else {
            publishedAt.parseZonedDateTimeOrDefault().toLocalDate()
        }
    }
}