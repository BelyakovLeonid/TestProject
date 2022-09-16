package com.belyakov.testproject.newslist.domain

import com.belyakov.testproject.newslist.domain.model.NewsModel
import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsListAsFlowUseCase @Inject constructor(
    private val repository: NewsListRepository
) {

    operator fun invoke(): Flow<List<NewsModel>> {
        return repository.getNewsAsFlow()
    }
}