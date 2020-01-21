package kr.ac.jejunu.hwahae.util

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

object MetricsUtil {
    fun convertPixelsToDp(px:Int , context:Context?) :Float {
        return if (context != null) {
            val resources = context.resources
            val metrics = resources.displayMetrics
            px / (metrics.densityDpi.toFloat()/DisplayMetrics.DENSITY_DEFAULT)
        } else {
            val metrics = Resources.getSystem().displayMetrics
            px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        }
    }
}