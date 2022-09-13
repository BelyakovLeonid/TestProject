package com.belyakov.testproject.base.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url
        val newUrl = url.newBuilder()
            .addQueryParameter(API_KEY_NAME, API_KEY)
            .build()

        val newRequest = request.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

    private companion object{
        const val API_KEY_NAME = "apiKey"
        const val API_KEY = "b536d80abd80435284fda380910aebb7" //todo
    }
}