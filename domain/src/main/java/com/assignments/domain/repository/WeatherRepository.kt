package com.assignments.domain.repository

import com.assignments.domain.model.Weather
import com.assignments.domain.repository.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    /**
     * Exposes a [Flow] with a list of the [Weather]s for the provided cities
     * @param cityNames The string names of the cities
     */
    suspend fun getWeatherForCities(
        cityNames: List<String>
    ): Resource<Flow<List<Weather>>>
}