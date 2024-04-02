package com.assignments.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Weather query DTO model
 */
@JsonClass(generateAdapter = true)
data class WeatherQueryDto(
    @field:Json(name = "coord")
    val coordinates: Coordinates,
    @field:Json(name = "weather")
    val weatherList: List<Weather>,
    val main: Main,
    val visibility: Int,
    val name: String,
)
