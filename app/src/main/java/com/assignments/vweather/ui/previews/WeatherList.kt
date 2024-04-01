package com.assignments.vweather.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.presentation.components.WeatherList
import com.assignments.presentation.model.UiWeather
import com.assignments.vweather.ui.theme.VWeatherTheme

@Preview
@Composable
fun WeatherListPreview() {

    val londonWeather = UiWeather(
        cityName = "London",
        currentTemperature = 3,
        name = "Rain",
        minTemperature = 0,
        maxTemperature = 11,
        subjectiveTemperature = 3,
        iconUrl = null,
    )

    val parisWeather = UiWeather(
        cityName = "Paris",
        currentTemperature = 6,
        name = "Cloudy",
        minTemperature = 2,
        maxTemperature = 15,
        subjectiveTemperature = 4,
        iconUrl = null,
    )

    val malagaWeather = UiWeather(
        cityName = "Mountain View",
        currentTemperature = 24,
        name = "Rain",
        minTemperature = 16,
        maxTemperature = 28,
        subjectiveTemperature = 26,
        iconUrl = null,
    )

    VWeatherTheme {

        WeatherList(
            uiWeatherList = listOf(
                londonWeather,
                parisWeather,
                malagaWeather,
            ),
            units = TemperatureUnits.Metric(),
            isRefreshing = false,
            onRefresh = {}
        )
    }
}