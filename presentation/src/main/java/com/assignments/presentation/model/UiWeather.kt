package com.assignments.presentation.model

import com.assignments.domain.repository.TemperatureUnits

data class UiWeather(
    val cityName: String,
    val currentTemperature: Int,
    val name: String,
    val minTemperature: Int,
    val maxTemperature: Int,
    val subjectiveTemperature: Int,
    val iconUrl: String?,
)