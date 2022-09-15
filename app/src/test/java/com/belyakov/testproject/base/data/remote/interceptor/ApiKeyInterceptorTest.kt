package com.belyakov.testproject.base.data.remote.interceptor

import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import okhttp3.Interceptor
import okhttp3.Request
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ApiKeyInterceptorTest {

    private lateinit var interceptor: ApiKeyInterceptor

    @Before
    fun setup() {
        interceptor = ApiKeyInterceptor()
    }

    @Test
    fun `api key is added to each request`() {
        val request = Request.Builder()
            .url("http://example")
            .build()

        val mockChain = mockk<Interceptor.Chain>()
        every { mockChain.request() } returns request
        val slot = slot<Request>()
        every { mockChain.proceed(capture(slot)) } returns mockk()

        interceptor.intercept(mockChain)

        verify { mockChain.proceed(any()) }
        assertEquals(true, slot.captured.url.queryParameterNames.contains("apiKey"))
    }
}