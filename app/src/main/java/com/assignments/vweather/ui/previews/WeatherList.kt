package com.assignments.vweather.ui.previews

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.assignments.presentation.components.WeatherList
import com.assignments.presentation.model.Weather
import com.assignments.vweather.ui.theme.VWeatherTheme

@Preview
@Composable
fun WeatherListPreview() {

    val londonWeather = Weather(
        cityName = "London",
        currentTemperature = 3,
        name = "Rain",
        minTemperature = 0,
        maxTemperature = 11,
        subjectiveTemperature = 3,
        iconUrl = null,
    )

    val parisWeather = Weather(
        cityName = "Paris",
        currentTemperature = 6,
        name = "Cloudy",
        minTemperature = 2,
        maxTemperature = 15,
        subjectiveTemperature = 4,
        iconUrl = null,
    )

    val malagaWeather = Weather(
        cityName = "Malaga",
        currentTemperature = 24,
        name = "Rain",
        minTemperature = 16,
        maxTemperature = 28,
        subjectiveTemperature = 26,
        iconUrl = null,
    )

    VWeatherTheme {

        WeatherList(
            weatherList = listOf(
                londonWeather,
                parisWeather,
                malagaWeather,
            ),
        )
    }
}