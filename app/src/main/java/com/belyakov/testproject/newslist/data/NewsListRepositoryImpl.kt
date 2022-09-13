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

    private var hasNextPage = true
    private var currentPage = 1

    override fun getNewsAsFlow(): Flow<List<NewsModel>> {
        return dao.getNewsAsFlow().map { newsList ->
            newsList.map(mapper::map)
        }
    }

    override suspend fun loadNewsNextPage() {
        val response = api.loadNewsList(
            pageSize = LOAD_PAGE_SIZE,
            page = currentPage,
            country = "us",
            category = null,
        )
        val items = mapper.map(response)

        hasNextPage = items.size == LOAD_PAGE_SIZE
        if (hasNextPage) currentPage++

        if (currentPage == 1) {
            //todo если совпадает с кешем, то оставляем кеш, иначе чистим
        } else {
            // todo просто кладем в кеш
        }
        dao.insertNews(items)
    }

    private companion object {
        const val LOAD_PAGE_SIZE = 10
    }
}