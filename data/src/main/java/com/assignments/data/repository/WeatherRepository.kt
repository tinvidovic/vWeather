package com.assignments.data.repository

import com.assignments.data.mapper.toWeather
import com.assignments.data.remote.OpenWeatherApi
import com.assignments.domain.model.Weather
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.domain.repository.WeatherRepository

class WeatherRepository(
    private val api: OpenWeatherApi
): WeatherRepository {
    override suspend fun getWeatherForCity(
        cityName: String,
        units: TemperatureUnits
    ): Result<Weather> {

        return try {

            val weatherQueryDto = api.getWeather(
                query = cityName,
                units = units.code
            )

            Result.success(
                weatherQueryDto.toWeather()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(
                e
            )
        }
    }

    override suspend fun getWeatherForCities(
        cityNames: List<String>,
        units: TemperatureUnits
    ): Result<List<Weather>> {
        return try {

            val weatherList = mutableListOf<Weather>()

            for (cityName in cityNames) {
                val weatherQueryDto = api.getWeather(
                    query = cityName,
                    units = units.code
                )

                weatherList.add(weatherQueryDto.toWeather())
            }

            Result.success(
                weatherList
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(
                e
            )
        }
    }

}