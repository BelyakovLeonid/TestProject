package com.belyakov.testproject.newsdetail.data

import com.belyakov.testproject.newsdetail.data.local.NewsDetailDao
import com.belyakov.testproject.newsdetail.domain.repository.NewsDetailRepository
import com.belyakov.testproject.newslist.data.mapper.NewsDataMapper
import com.belyakov.testproject.newslist.domain.model.NewsModel
import javax.inject.Inject

class NewsDetailRepositoryImpl @Inject constructor(
    private val dao: NewsDetailDao,
    private val mapper: NewsDataMapper
) : NewsDetailRepository {

    override suspend fun getNewsById(id: String): NewsModel {
        return mapper.map(dao.getNewsById(id))
    }
}