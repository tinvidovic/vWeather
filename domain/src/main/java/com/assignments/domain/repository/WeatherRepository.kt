package com.assignments.domain.repository

import com.assignments.domain.model.Weather

interface WeatherRepository {

    suspend fun getWeatherForCity(
        cityName: String,
        units: TemperatureUnits
    ): Result<Weather>

    suspend fun getWeatherForCities(
        cityNames: List<String>,
        units: TemperatureUnits
    ): Result<List<Weather>>
}