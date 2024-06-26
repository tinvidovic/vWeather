package com.assignments.vweather.ui.previews

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.presentation.components.WeatherCard
import com.assignments.presentation.model.UiWeather
import com.assignments.vweather.ui.theme.VWeatherTheme

@Preview
@Composable
fun WeatherCardPreview() {

    val londonWeather = UiWeather(
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
            uiWeather = londonWeather,
            units = TemperatureUnits.Metric(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}