package com.wix.detoxinteractionutils

import android.graphics.Rect
import android.view.View

fun View.findInteractionRegion(): Rect? {
    val region = Rect()
    return (if (getGlobalVisibleRect(region)) region else null)
}
