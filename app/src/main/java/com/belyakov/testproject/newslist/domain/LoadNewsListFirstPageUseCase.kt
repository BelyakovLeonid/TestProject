package com.belyakov.testproject.newslist.domain

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import javax.inject.Inject

class LoadNewsListFirstPageUseCase @Inject constructor(
    private val repository: NewsListRepository
) {

    suspend operator fun invoke(filters: List<FilterModel>) {
        return repository.loadNewsFirstPage(filters)
    }
}