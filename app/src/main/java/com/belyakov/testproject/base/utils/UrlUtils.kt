package com.belyakov.testproject.base.utils

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

fun String.encodeUrl(): String{
    return URLEncoder.encode(this, StandardCharsets.UTF_8.toString())
}