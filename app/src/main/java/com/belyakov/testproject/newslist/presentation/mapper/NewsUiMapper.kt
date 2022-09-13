package com.belyakov.testproject.newslist.presentation.mapper

import com.belyakov.testproject.newslist.domain.model.NewsModel
import com.belyakov.testproject.newslist.presentation.model.NewsUiModel
import javax.inject.Inject

class NewsUiMapper @Inject constructor() {

    fun map(model: NewsModel): NewsUiModel {
        return NewsUiModel(
            id = model.id,
            title = model.title,
            source = model.source,
            date = "model.publishedAt", // todo
            imageUrl = model.imageUrl,
            content = model.content
        )
    }
}