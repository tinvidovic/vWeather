package com.assignments.vweather.repository

import androidx.core.app.PendingIntentCompat.send
import com.assignments.domain.model.Weather
import com.assignments.domain.repository.WeatherRepository
import com.assignments.domain.repository.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest

class WeatherRepositoryFake: WeatherRepository {

    var shouldReturnError = false

    var weatherList = listOf(
        Weather(
            latitude = 0f,
            longitude = 0f,
            id = 0,
            main = "Cloudy",
            description = "A bit cloudy.",
            icon = "",
            temperature = 10F,
            pressure = null,
            humidity = null,
            minTemperature = -1F,
            maxTemperature = 10F,
            visibility = null,
            name = "Stockholm",
        ),
        Weather(
            latitude = 0f,
            longitude = 0f,
            id = 0,
            main = "Rain",
            description = "Moderate rain.",
            icon = "",
            temperature = 8F,
            pressure = null,
            humidity = null,
            minTemperature = 4F,
            maxTemperature = 12F,
            visibility = null,
            name = "London",
        )
    )

    private val weatherFlow = MutableStateFlow(weatherList)
    override suspend fun getWeatherForCities(cityNames: List<String>): Resource<Flow<List<Weather>>> {

        return if (shouldReturnError) {
            Resource.Error(weatherFlow)
        } else {
            Resource.Success(weatherFlow)
        }
    }
}