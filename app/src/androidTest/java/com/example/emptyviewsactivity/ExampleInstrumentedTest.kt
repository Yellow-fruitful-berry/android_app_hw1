package com.example.emptyviewsactivity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testGenerateLogNormal() {
        onView(withId(R.id.mean_val)).perform(typeText("0.5"), closeSoftKeyboard())

        onView(withId(R.id.variance_value)).perform(typeText("0.25"), closeSoftKeyboard())

        onView(withId(R.id.get_random_num)).perform(click())

        onView(withId(R.id.random_number_result))
            .check(matches(not(withText(""))))
    }
}
