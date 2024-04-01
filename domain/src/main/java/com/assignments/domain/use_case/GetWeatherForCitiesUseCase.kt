package com.assignments.domain.use_case

import com.assignments.domain.model.Weather
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.domain.repository.WeatherRepository
import com.assignments.domain.repository.util.Resource
import kotlinx.coroutines.flow.Flow

class GetWeatherForCitiesUseCase(
    private val weatherRepository: WeatherRepository,
) {

    /**
     * Returns [Resource] with a list of weathers for each of the cityNames
     * @param cityNames The city names to query weather for
     */
    suspend operator fun invoke(
        cityNames: List<String>,
    ): Resource<Flow<List<Weather>>> {
        return weatherRepository.getWeatherForCities(
            cityNames = cityNames,
        )
    }
}