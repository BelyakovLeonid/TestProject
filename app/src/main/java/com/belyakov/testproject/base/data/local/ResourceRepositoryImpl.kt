package com.belyakov.testproject.base.data.local

import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import com.belyakov.testproject.base.domain.repository.ResourceRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ResourceRepository {

    override fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }

    override fun getString(@StringRes resId: Int, vararg arguments: Any): String {
        return context.getString(resId, *arguments)
    }

    override fun getQuantityString(@PluralsRes resId: Int, argument: Int): String {
        return context.resources.getQuantityString(resId, argument, argument)
    }
}