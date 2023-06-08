package com.wix.detoxinteractionutils

import android.util.Log
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.CoordinatesProvider
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.detoxinteractionutils.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InteractableRegionTest {

    private val feedbackText = "Tap Success"

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val coordinatesProvider = CoordinatesProvider { view: View ->
        view.findInteractionRegion()?.let { rect ->
            floatArrayOf(rect.exactCenterX(), rect.exactCenterY()).also {
                Log.w("E2E", "Found interaction region $rect; Will provide coordinates (${it[0]}, ${it[1]})")
            }
        }
    }

    @Test
    fun shouldInteractUnderFullVisibility() {
        onView(withId(R.id.btnNavFullVisibility)).perform(click())

        onView(withText(feedbackText)).checkNotVisible()
        onView(withId(R.id.btnTarget)).performClick(coordinatesProvider)
        onView(withText(feedbackText)).checkVisible()
    }

//    @Test
//    fun shouldInteractUnderLocalObstruction() {
//        onView(withId(R.id.btnNavLocalObstruction))
//
//        // TODO
//    }
}
