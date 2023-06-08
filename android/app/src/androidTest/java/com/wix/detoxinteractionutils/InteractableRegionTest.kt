package com.wix.detoxinteractionutils

import android.util.Log
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.CoordinatesProvider
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.detoxinteractionutils.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InteractableRegionTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val coordinatesProvider = CoordinatesProvider { view: View ->
        view.findInteractionRegion()?.let { rect ->
            floatArrayOf(rect.exactCenterX(), rect.exactCenterY())
        }
    }

    @Test
    fun shouldInteractUnderFullVisibility() {
        val feedbackText = "Tap Success"

        onView(withText(feedbackText)).checkNotVisible()
        onView(withId(R.id.btnTarget)).performClick(coordinatesProvider)
        onView(withText(feedbackText)).checkVisible()
    }
}
