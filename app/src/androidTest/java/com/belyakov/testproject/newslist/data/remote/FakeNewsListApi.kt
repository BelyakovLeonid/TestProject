package com.belyakov.testproject.newslist.data.remote

import com.belyakov.testproject.newslist.data.remote.model.NewsDto
import com.belyakov.testproject.newslist.data.remote.model.NewsListDto
import com.belyakov.testproject.newslist.data.remote.model.NewsSourceDto
import javax.inject.Inject

class FakeNewsListApi @Inject constructor() : NewsListApi {

    override suspend fun loadNewsList(pageSize: Int, page: Int, country: String?, category: String?): NewsListDto {
        return NewsListDto(
            totalResults = 1,
            articles = listOf(
                NewsDto(
                    publishedAt = "2022-09-15T18:02:31Z",
                    author = "Will Smith",
                    url = "http://someUrl",
                    description = "someDescription",
                    source = NewsSourceDto(
                        name = "CNN",
                        id = "123"
                    ),
                    title = "someTitle",
                    urlToImage = "http://someUrlToImage",
                    content = "someContent",
                )
            ),
            status = "OK"
        )
    }
}