package com.assignments.presentation.weather

sealed class WeatherEvent {
    data class OnUnitCheckedChanged(val checked: Boolean) : WeatherEvent()
    object OnWeatherListRefresh : WeatherEvent()
}