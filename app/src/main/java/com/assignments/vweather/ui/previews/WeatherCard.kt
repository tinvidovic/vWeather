package com.assignments.vweather.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.assignments.presentation.components.WeatherCard
import com.assignments.presentation.model.Weather
import com.assignments.vweather.ui.theme.VWeatherTheme

@Preview
@Composable
fun WeatherCardPreview() {

    val londonWeather = Weather(
        cityName = "London",
        currentTemperature = 3,
        name = "Rain",
        minTemperature = 0,
        maxTemperature = 11,
        subjectiveTemperature = 3,
        iconUrl = null,
    )
    VWeatherTheme {

        WeatherCard(
            weather = londonWeather
            //modifier = Modifier.fillMaxWidth()
        )
    }
}