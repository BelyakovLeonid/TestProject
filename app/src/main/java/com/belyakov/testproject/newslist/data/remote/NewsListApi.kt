package com.belyakov.testproject.newslist.data.remote

import com.belyakov.testproject.newslist.data.remote.model.NewsListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsListApi {

    @GET("top-headlines")
    suspend fun loadNewsList(
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
        @Query("country") country: String? = null,
        @Query("category") category: String? = null
    ): NewsListDto
}