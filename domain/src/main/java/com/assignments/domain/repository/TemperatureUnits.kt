package com.assignments.domain.repository

sealed class TemperatureUnits(val code: String) {
    class Metric(code: String = "metric"): TemperatureUnits(code)
    class Imperial(code: String = "imperial"): TemperatureUnits(code)
}