package com.assignments.data.remote

import com.assignments.data.remote.dto.WeatherQueryDto
import com.assignments.domain.repository.TemperatureUnits
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {

    /**
     * Fetches a [WeatherQueryDto] with the provided settings
     * @param units The [TemperatureUnits], expected in the response for temperature values
     */
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") query: String,
        // NOTE: Should normally store these in local properties and integrate with something like
        // Github secrets, but since it is a free plan and for the sake of simplicity they are here
        @Query("appId") appID: String = "1ee46290d45ab833a434afa7f074e092",
        @Query("units") units: String = TemperatureUnits.Metric().code
    ): WeatherQueryDto

    companion object {

        const val BASE_URL = "https://api.openweathermap.org/"
    }
}