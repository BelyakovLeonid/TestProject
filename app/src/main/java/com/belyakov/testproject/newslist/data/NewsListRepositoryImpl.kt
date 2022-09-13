package com.belyakov.testproject.newslist.data

import com.belyakov.testproject.newslist.data.local.NewsListDao
import com.belyakov.testproject.newslist.data.mapper.NewsDataMapper
import com.belyakov.testproject.newslist.data.remote.NewsListApi
import com.belyakov.testproject.newslist.domain.model.NewsModel
import com.belyakov.testproject.newslist.domain.repository.NewsListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsListRepositoryImpl @Inject constructor(
    private val api: NewsListApi,
    private val dao: NewsListDao,
    private val mapper: NewsDataMapper
) : NewsListRepository {

    override fun getNewsAsFlow(): Flow<List<NewsModel>> {
        return dao.getNewsAsFlow().map { newsList ->
            newsList.map(mapper::map)
        }
    }

    override suspend fun loadNewsFirstPage() {
        val items = api.loadNewsList(
            pageSize = LOAD_PAGE_SIZE,
            page = 1,
            country = "us",
            category = null,
        )
        dao.insertNews(mapper.map(items))
    }

    private companion object {
        const val LOAD_PAGE_SIZE = 10
    }
}