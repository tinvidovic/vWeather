package com.assignments.data.repository

import com.assignments.data.local.WeatherDao
import com.assignments.data.mapper.toWeather
import com.assignments.data.mapper.toWeatherEntity
import com.assignments.data.remote.OpenWeatherApi
import com.assignments.domain.model.Weather
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.domain.repository.WeatherRepository
import com.assignments.domain.repository.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherRepository(
    private val api: OpenWeatherApi,
    private val dao: WeatherDao,
): WeatherRepository {

    override suspend fun getWeatherForCities(
        cityNames: List<String>,
        units: TemperatureUnits
    ): Resource<Flow<List<Weather>>> {

        var requestFailed = true

        try {

            for (cityName in cityNames) {
                val weatherQueryDto = api.getWeather(
                    query = cityName,
                    units = units.code
                )

                dao.insertWeather(weatherQueryDto.toWeatherEntity())
            }

            requestFailed = false

        } catch (e: Exception) {
            e.printStackTrace()
            requestFailed = true
        }

        return if (requestFailed) {
            Resource.Error(
                data = dao.getWeathers().map { weatherEntities ->
                    weatherEntities.map {
                        it.toWeather()
                    }
                }
            )
        } else {
            Resource.Success(
                data = dao.getWeathers().map { weatherEntities ->
                    weatherEntities.map {
                        it.toWeather()
                    }
                }
            )
        }
    }

}