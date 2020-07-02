package com.example.tests

import android.content.Context
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {
    private val WEAK_PASSWORD = "password"
    private val STRONG_PASSWORD = "paSswOrd31"

    private val WEAK_STATUS = "Слабый"
    private val STRONG_STATUS = "Сильный"

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        val packageName: String = InstrumentationRegistry.getInstrumentation().targetContext.packageName
        val context: Context = InstrumentationRegistry.getInstrumentation().context
        val intent: Intent = context.packageManager.getLaunchIntentForPackage(packageName)!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        context.startActivity(intent)
    }

    @Test
    fun badPasswordStatusIsDisplayed() {
        onView(withId(R.id.etPassword))
            .perform(
                typeText(WEAK_PASSWORD),
                closeSoftKeyboard()
            )

        onView(withId(R.id.btnCheckPassword)).perform(click())

        onView(withId(R.id.tvPasswordStatus)).check(matches(withText(WEAK_STATUS)))
    }

    @Test
    fun strongPasswordStatusIsDisplayed() {
        onView(withId(R.id.etPassword))
            .perform(
                typeText(STRONG_PASSWORD),
                closeSoftKeyboard()
            )

        onView(withId(R.id.btnCheckPassword)).perform(click())

        onView(withId(R.id.tvPasswordStatus)).check(matches(withText(STRONG_STATUS)))
    }
}