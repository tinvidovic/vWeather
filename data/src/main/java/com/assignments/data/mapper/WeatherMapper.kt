package com.assignments.data.mapper

import com.assignments.data.local.entity.WeatherEntity
import com.assignments.data.remote.dto.WeatherQueryDto
import com.assignments.domain.model.Weather
fun WeatherQueryDto.toWeatherEntity(): WeatherEntity {

    val firstWeather = weatherList.first()

    return WeatherEntity(
        latitude = coordinates.latitude,
        longitude = coordinates.longitude,
        weatherId = firstWeather.id,
        weatherMain = firstWeather.main,
        weatherDescription = firstWeather.description,
        weatherIcon = firstWeather.icon,
        mainTemperature = main.temperature,
        mainPressure = main.pressure,
        mainHumidity = main.humidity,
        mainMinTemperature = main.minTemperature,
        mainMaxTemperature = main.maxTemperature,
        visibility = visibility,
        name = name
    )
}

fun WeatherEntity.toWeather(): Weather {

    return Weather(
        latitude = latitude,
        longitude = longitude,
        id = weatherId,
        main = weatherMain,
        description = weatherDescription,
        icon = weatherIcon,
        temperature = mainTemperature,
        pressure = mainPressure,
        humidity = mainHumidity,
        minTemperature = mainMinTemperature,
        maxTemperature = mainMaxTemperature,
        visibility = visibility,
        name = name
    )
}