package com.assignments.domain.use_case

import com.assignments.domain.model.Weather
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.domain.repository.WeatherRepository

class GetWeatherForCitiesUseCase(
    private val weatherRepository: WeatherRepository,
) {

    /**
     * Returns [Result] with a list of weathers for each of the cityNames
     * @param cityNames The city names to query weather for
     */
    suspend operator fun invoke(
        cityNames: List<String>,
        units: TemperatureUnits,
    ): Result<List<Weather>> {
        return weatherRepository.getWeatherForCities(
            cityNames = cityNames,
            units
        )
    }
}