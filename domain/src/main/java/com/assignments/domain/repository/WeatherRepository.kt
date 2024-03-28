package com.assignments.domain.repository

import com.assignments.domain.model.Weather

interface WeatherRepository {

    suspend fun getWeatherForCity(
        cityName: String,
    ): Result<Weather>

    suspend fun getWeatherForCities(
        cityNames: List<String>
    ): Result<List<Weather>>
}