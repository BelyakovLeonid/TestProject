package com.belyakov.testproject.newslist.data

import com.belyakov.testproject.filter.domain.model.FilterModel
import com.belyakov.testproject.filter.domain.model.FilterType
import com.belyakov.testproject.newslist.data.local.NewsListDao
import com.belyakov.testproject.newslist.data.local.model.NewsEntity
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

    override suspend fun loadNewsFirstPage(filters: List<FilterModel>) {
        currentPage = 1
        hasNextPage = true

        val loadedNews = loadPage(filters)
        dao.deleteAndInsert(loadedNews)
    }

    override suspend fun loadNewsNextPage(filters: List<FilterModel>) {
        if (hasNextPage) {
            val loadedNews = loadPage(filters)
            dao.insert(loadedNews)
        }
    }

    private suspend fun loadPage(filters: List<FilterModel>): List<NewsEntity> {
        val response = api.loadNewsList(
            pageSize = LOAD_PAGE_SIZE,
            page = currentPage,
            country = filters.firstOrNull { it.type == FilterType.COUNTRY }?.value,
            category = filters.firstOrNull { it.type == FilterType.CATEGORY }?.value,
        )
        val entities = mapper.map(response)

        hasNextPage = entities.size == LOAD_PAGE_SIZE
        if (hasNextPage) currentPage++

        return entities
    }

    private companion object {
        const val LOAD_PAGE_SIZE = 10
    }
}