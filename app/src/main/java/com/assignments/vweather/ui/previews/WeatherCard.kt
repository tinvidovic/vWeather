package com.assignments.vweather.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.assignments.presentation.components.WeatherCard
import com.assignments.vweather.ui.theme.VWeatherTheme

@Preview
@Composable
fun WeatherCardPreview() {

    VWeatherTheme {

        WeatherCard(
            city = "London",
            currentTemperature = 3,
            weather = "Rain",
            minTemperature = 0,
            maxTemperature = 11,
            subjectiveTemperature = 3,
            iconUrl = null,
            //modifier = Modifier.fillMaxWidth()
        )
    }
}