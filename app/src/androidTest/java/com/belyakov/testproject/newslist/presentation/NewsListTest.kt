package com.belyakov.testproject.newslist.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.belyakov.testproject.root.RootActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class NewsListTest {

    @get:Rule(order = 0)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<RootActivity>()

    @Test
    fun i_can_see_the_app_bar() {
        composeTestRule.onNodeWithText("All News").assertIsDisplayed()
    }

    @Test
    fun i_can_open_filters_screen() {
        composeTestRule.onNodeWithContentDescription("Filter").performClick()
        composeTestRule.onNodeWithTag("FilterScreen").assertIsDisplayed()
    }

    @Test
    fun i_can_open_news_detail_screen() {
        composeTestRule.onNodeWithText("someTitle").performClick()
        composeTestRule.onNodeWithTag("NewsDetailScreen").assertIsDisplayed()
    }
}