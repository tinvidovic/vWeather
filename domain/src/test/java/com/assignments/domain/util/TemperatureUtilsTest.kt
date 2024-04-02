package com.assignments.domain.util

import com.assignments.domain.repository.TemperatureUnits
import com.assignments.domain.util.TemperatureUtils.getMetricTemperatureIn
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import kotlin.random.Random


class TemperatureUtilsTest {

    @Test
    fun `getMetricTemperatureIn, converting to metric returns same value`() {

        repeat(100) {
            val metricValue = Random.nextInt()
            assertThat(getMetricTemperatureIn(metricValue, TemperatureUnits.Metric())).isEqualTo(metricValue)
        }
    }

    @Test
    fun `getMetricTemperatureIn, converting to imperial returns correct result`() {

        val metricValues = listOf(
            -273,
            -52,
            0,
            5,
            1,
            500
        )

        val expectedImperial = listOf(
            -459,
            -62,
            32,
            41,
            34,
            932
        )

        metricValues.forEachIndexed { index, metricValue ->
            assertThat(getMetricTemperatureIn(metricValue, TemperatureUnits.Imperial())).isEqualTo(expectedImperial[index])
        }
    }
}