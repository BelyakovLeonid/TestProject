package com.belyakov.testproject.newslist.data.remote.model

class NewsDto(
	val publishedAt: String,
	val author: String,
	val urlToImage: String,
	val description: String,
	val source: NewsSourceDto,
	val title: String,
	val url: String,
	val content: String
)