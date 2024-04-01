package com.assignments.domain.util

import com.assignments.domain.repository.TemperatureUnits
import kotlin.math.roundToInt

object TemperatureUtils {

    /**
     * Returns the passed in metric temperature converted to the requested [TemperatureUnits]
     */
    fun getMetricTemperatureIn(
        temperature: Int,
        units: TemperatureUnits,
    ): Int {

        return if (units is TemperatureUnits.Metric) {
            temperature
        } else {
            (temperature * 9F/5F + 32).roundToInt()
        }
    }
}