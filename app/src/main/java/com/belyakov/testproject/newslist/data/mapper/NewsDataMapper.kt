package com.belyakov.testproject.newslist.data.mapper

import com.belyakov.testproject.newslist.data.local.model.NewsEntity
import com.belyakov.testproject.newslist.data.remote.model.NewsListDto
import com.belyakov.testproject.newslist.domain.model.NewsModel
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import javax.inject.Inject

class NewsDataMapper @Inject constructor() {

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

    fun map(dto: NewsListDto): List<NewsEntity> { //todo
        return dto.articles.map { newsDto ->
            NewsEntity(
                title = newsDto.title ?: "", //todo нужны ли такие новости?
                imageUrl = newsDto.urlToImage,
                publishedAt = ZonedDateTime.parse(newsDto.publishedAt).toLocalDate(), // todo обернуть
                source = newsDto.source?.name ?: "Unknown", // todo в ресурсы
                content = newsDto.content ?: "", //todo нужны ли такие новости?
            )
        }
    }
}