package com.jess.tablayout.common.adapter

import android.content.Context
import android.util.TypedValue

object ViewUtils {
    fun Int.dpToPx(context: Context): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        toFloat(),
        context.resources.displayMetrics
    ).toInt()
}