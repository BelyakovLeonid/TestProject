package com.belyakov.testproject.base.data.local

import android.content.Context
import com.belyakov.testproject.base.domain.repository.ResourceRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ResourceRepository {

    override fun getString(resId: Int): String {
        return context.getString(resId)
    }
}