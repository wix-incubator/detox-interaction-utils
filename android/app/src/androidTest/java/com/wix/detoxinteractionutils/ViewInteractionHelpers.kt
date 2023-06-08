package com.wix.detoxinteractionutils

import android.view.InputDevice
import android.view.MotionEvent
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.CoordinatesProvider
import androidx.test.espresso.action.GeneralClickAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Tap
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers.not

fun ViewInteraction.performClick(coordinatesProvider: CoordinatesProvider) {
    this.perform(customClickAction(coordinatesProvider))
}

fun ViewInteraction.checkNotVisible() {
    this.check(ViewAssertions.matches(not(ViewMatchers.isCompletelyDisplayed())))
}


fun ViewInteraction.checkVisible() {
    this.check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))
}

private fun customClickAction(coordinatesProvider: CoordinatesProvider): ViewAction =
    ViewActions.actionWithAssertions(
        GeneralClickAction(
            Tap.SINGLE,
            coordinatesProvider,
            Press.FINGER,
            InputDevice.SOURCE_UNKNOWN,
            MotionEvent.BUTTON_PRIMARY
        )
    )
