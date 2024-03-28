package com.assignments.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.presentation.model.UiWeather

@Composable
fun WeatherList(
    uiWeatherList: List<UiWeather>,
    units: TemperatureUnits,
    modifier: Modifier = Modifier,
    largeStyle: TextStyle = MaterialTheme.typography.displayLarge.copy(
        color = MaterialTheme.colorScheme.onPrimary
    ),
    mediumStyle: TextStyle = MaterialTheme.typography.displayMedium.copy(
        color = MaterialTheme.colorScheme.onPrimary
    ),
    smallStyle: TextStyle = MaterialTheme.typography.displaySmall.copy(
        color = MaterialTheme.colorScheme.onPrimary
    ),
) {

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(uiWeatherList) { weather ->

            WeatherCard(
                uiWeather = weather,
                largeStyle = largeStyle,
                mediumStyle = mediumStyle,
                smallStyle = smallStyle,
                units = units,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}