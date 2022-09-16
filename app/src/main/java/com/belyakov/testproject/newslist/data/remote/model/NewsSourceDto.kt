package com.belyakov.testproject.newslist.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
class NewsSourceDto(
	val name: String?,
	val id: String?
)
