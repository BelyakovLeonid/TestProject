package com.belyakov.testproject.base.domain.repository

import androidx.annotation.StringRes

interface ResourceRepository {

    fun getString(@StringRes resId: Int): String
}