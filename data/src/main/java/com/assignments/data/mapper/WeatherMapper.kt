package com.assignments.data.mapper

import com.assignments.data.remote.dto.WeatherQueryDto
import com.assignments.domain.model.Weather

fun WeatherQueryDto.toWeather(): Weather {

    val weather = weatherList.first()

    return Weather(
        latitude = coordinates.latitude,
        longitude = coordinates.longitude,
        id = weather.id,
        main = weather.main,
        description = weather.description,
        icon = weather.icon,
        temperature = main.temperature,
        pressure = main.pressure,
        humidity = main.humidity,
        minTemperature = main.minTemperature,
        maxTemperature = main.maxTemperature,
        visibility = visibility
    )
}