package com.assignments.domain.model

data class Weather(
    val latitude: Float,
    val longitude: Float,
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
    val temperature: Float?,
    val pressure: Int?,
    val humidity: Int?,
    val minTemperature: Float?,
    val maxTemperature: Float?,
    val visibility: Int?
)