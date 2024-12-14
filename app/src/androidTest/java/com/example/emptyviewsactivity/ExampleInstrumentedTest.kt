package com.example.emptyviewsactivity

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.not

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)  // This ensures the activity is launched

    @Test
    fun testGenerateLogNormal() {
        // Enter a value for mean
        onView(withId(R.id.mean_val)).perform(typeText("0.5"), closeSoftKeyboard())

        // Enter a value for variance
        onView(withId(R.id.variance_value)).perform(typeText("0.25"), closeSoftKeyboard())

        // Click the submit button
        onView(withId(R.id.get_random_num)).perform(click())

        // Check that a result appears
        onView(withId(R.id.random_number_result))
            .check(matches(not(withText("")))) // Ensure the result is not empty
    }
}