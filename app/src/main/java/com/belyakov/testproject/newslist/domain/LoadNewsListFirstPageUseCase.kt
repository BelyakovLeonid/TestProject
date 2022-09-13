package com.belyakov.testproject.newslist.domain

import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import javax.inject.Inject

class LoadNewsListFirstPageUseCase @Inject constructor(
    private val repository: NewsListRepository
) {

    suspend operator fun invoke() {
        return repository.loadNewsNextPage()
    }
}