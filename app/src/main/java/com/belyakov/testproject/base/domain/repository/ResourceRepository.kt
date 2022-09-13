package com.belyakov.testproject.base.domain.repository

import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

interface ResourceRepository {

    fun getString(@StringRes resId: Int): String
    fun getString(@StringRes resId: Int, vararg arguments: Any): String
    fun getQuantityString(@PluralsRes resId: Int, argument: Int): String
}