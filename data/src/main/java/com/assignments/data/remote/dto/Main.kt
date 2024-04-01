package com.assignments.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Weather query DTO model helper
 * @see [WeatherQueryDto]
 */
@JsonClass(generateAdapter = true)
data class Main(
    @field:Json(name = "temp")
    val temperature: Float?,
    val pressure: Int?,
    val humidity: Int?,
    @field:Json(name = "temp_min")
    val minTemperature: Float?,
    @field:Json(name = "temp_max")
    val maxTemperature: Float?,
)