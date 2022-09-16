package com.belyakov.testproject.rules

import androidx.compose.ui.test.junit4.createComposeRule
import io.cucumber.junit.WithJunitRule
import org.junit.Rule

@WithJunitRule
class ComposeRuleHolder {

    @get:Rule(order = 1)
    val composeRule = createComposeRule()
}