package com.belyakov.testproject.newslist.domain.repository

import com.belyakov.testproject.newslist.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface NewsListRepository {
    fun getNewsAsFlow(): Flow<NewsModel>
    suspend fun loadNewsFirstPage()
}