package com.belyakov.testproject.newslist.data

import com.belyakov.testproject.newslist.data.remote.NewsListApi
import com.belyakov.testproject.newslist.domain.model.NewsModel
import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class NewsListRepositoryImpl @Inject constructor(
    private val api: NewsListApi
): NewsListRepository {

    override fun getNewsAsFlow(): Flow<NewsModel> {
        return flowOf()
    }

    override suspend fun loadNewsFirstPage() {
        api.loadNewsList(
            pageSize = LOAD_PAGE_SIZE,
            page = 1,
            country = null,
            category =null ,

        )
    }

    private companion object{
        const val LOAD_PAGE_SIZE = 10
    }
}