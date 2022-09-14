package com.belyakov.testproject.newsdetail.domain

import com.belyakov.testproject.newsdetail.domain.repository.NewsDetailRepository
import com.belyakov.testproject.newslist.domain.model.NewsModel
import javax.inject.Inject

class GetNewsByIdUseCase @Inject constructor(
    private val repository: NewsDetailRepository
) {

    suspend operator fun invoke(id: String): NewsModel {
        return repository.getNewsById(id)
    }
}