package com.assignments.data.remote.dto

import com.squareup.moshi.JsonClass

/**
 * Weather query DTO model helper
 * @see [WeatherQueryDto]
 */
@JsonClass(generateAdapter = true)
data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)
