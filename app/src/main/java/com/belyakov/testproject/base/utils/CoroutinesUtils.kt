package com.belyakov.testproject.base.utils

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun CoroutineScope.launchCatching(
    onError: (t: Throwable) -> Unit,
    block: suspend CoroutineScope.() -> Unit
): Job {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError(throwable)
    }

    return launch(context = (this.coroutineContext + exceptionHandler)) {
        block()
    }
}
