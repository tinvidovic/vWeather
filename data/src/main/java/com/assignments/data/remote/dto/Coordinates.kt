package com.assignments.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Weather query DTO model helper
 * @see [WeatherQueryDto]
 */
@JsonClass(generateAdapter = true)
data class Coordinates(
    @field:Json(name = "lon")
    val longitude: Float,
    @field:Json(name = "lat")
    val latitude: Float,
)