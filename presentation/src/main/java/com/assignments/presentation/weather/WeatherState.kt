package com.assignments.presentation.weather

import com.assignments.presentation.model.UiWeather

data class WeatherState(
    val uiWeatherList: List<UiWeather> = emptyList(),
    val unitSwitchChecked: Boolean = false
)