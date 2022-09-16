package com.belyakov.testproject.rules

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.cucumber.junit.WithJunitRule
import org.junit.Rule

@WithJunitRule(useAsTestClassInDescription = true)
@HiltAndroidTest
class HiltRuleHolder {

    @Rule(order = 0)
    @JvmField
    val hiltRule = HiltAndroidRule(this)
}