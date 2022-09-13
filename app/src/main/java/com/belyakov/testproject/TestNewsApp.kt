package com.belyakov.testproject

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TestNewsApp: Application(){

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}