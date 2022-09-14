package com.belyakov.testproject.newslist.domain.repository

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.newslist.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface NewsListRepository {
    fun getNewsAsFlow(): Flow<List<NewsModel>>
    suspend fun loadNewsFirstPage(filters: List<FilterModel>)
    suspend fun loadNewsNextPage(filters: List<FilterModel>)
}