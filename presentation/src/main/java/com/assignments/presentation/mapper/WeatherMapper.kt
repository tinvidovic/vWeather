package com.assignments.presentation.mapper

import com.assignments.domain.model.Weather
import com.assignments.presentation.model.UiWeather
import kotlin.math.roundToInt

fun Weather.toUiWeather(): UiWeather {

    return UiWeather(
        cityName = name,
        currentTemperature = temperature?.roundToInt() ?: 0,
        name = main,
        minTemperature = minTemperature?.roundToInt() ?: 0,
        maxTemperature = maxTemperature?.roundToInt() ?: 0,
        subjectiveTemperature = this.temperature?.roundToInt() ?: 0,
        iconUrl = "https://openweathermap.org/img/wn/$icon@2x.png"
    )
}