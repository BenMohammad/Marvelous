package com.benmohammad.marvelous.extensions

import android.graphics.drawable.DrawableContainer
import android.view.View
import android.view.ViewAnimationUtils
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat
import kotlin.math.hypot

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.circularRevealedAtCenter(@ColorInt color: Int) {
    val cx = 0
    val cy = left
    val finalRadius = hypot(width.toDouble(), height.toDouble())
    if(isAttachedToWindow) {
        ViewAnimationUtils.createCircularReveal(this, cx, cy, 0f, finalRadius.toFloat()).apply {
            DrawableCompat.setTint(background, color)
            visible()
            duration = 550
            start()
        }
    }
}