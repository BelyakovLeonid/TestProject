package com.belyakov.testproject

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.hilt.navigation.compose.hiltViewModel
import com.belyakov.testproject.base.presentation.theme.TestNewsTheme
import com.belyakov.testproject.newslist.presentation.NewsListScreen
import com.belyakov.testproject.root.RootActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Rule

@HiltAndroidTest
class NewsListSteps {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<RootActivity>()

    @Given("I open NewsListScreen")
    fun i_open_NewsListScreen() {
        composeTestRule.setContent {
            TestNewsTheme {
                NewsListScreen(
                    onNavigate = {},
                    viewModel = hiltViewModel(),
                )
            }
        }
    }

    @And("I click filter button")
    fun i_click_filter_button() {
        composeTestRule.onNodeWithText("Filter").performClick()
    }

    @Then("I expect to see filters dialog")
    fun i_expect_to_see_filters_dialog() {
        composeTestRule.onNodeWithTag("FilterScreen").assertIsDisplayed()
    }
}