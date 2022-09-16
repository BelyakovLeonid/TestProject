package com.belyakov.testproject.newsdetail.domain.repository

import com.belyakov.testproject.newslist.domain.model.NewsModel

interface NewsDetailRepository {
    suspend fun getNewsById(id: String): NewsModel
}