package com.belyakov.testproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.belyakov.testproject.base.presentation.theme.TestProjectTheme
import com.belyakov.testproject.detail.presentation.NewsDetailScreen
import com.belyakov.testproject.detail.presentation.NewsDetailScreenPreview
import com.belyakov.testproject.main.presentation.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestProjectTheme {
                NewsDetailScreen()
            }
        }
    }
}