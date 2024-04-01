package com.assignments.domain.repository

import com.assignments.domain.model.Weather
import com.assignments.domain.repository.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun getWeatherForCities(
        cityNames: List<String>
    ): Resource<Flow<List<Weather>>>
}