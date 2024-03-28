package com.assignments.presentation.model

data class Weather(
    val cityName: String,
    val currentTemperature: Int,
    val name: String,
    val minTemperature: Int,
    val maxTemperature: Int,
    val subjectiveTemperature: Int,
    val iconUrl: String?,
)