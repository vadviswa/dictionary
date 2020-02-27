package com.example.dictionary

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun defaultView() {
        onView(
            Matchers.allOf(
                withId(R.id.searchTerm)
            )
        ).check(matches(isDisplayed()))
        onView(
            Matchers.allOf(
                withId(R.id.searchButton),
                withText(R.string.search)
            )
        ).check(matches(isDisplayed()))

        onView(
            Matchers.allOf(
                withId(R.id.progress_circular),
                withText(R.string.search)
            )
        ).check(doesNotExist())
    }
}
