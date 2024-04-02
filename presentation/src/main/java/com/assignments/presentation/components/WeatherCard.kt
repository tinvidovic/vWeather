package com.assignments.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.domain.util.TemperatureUtils.getMetricTemperatureIn
import com.assignments.presentation.model.UiWeather
import com.assignments.vweather.presentation.R

@Composable
fun WeatherCard(
    uiWeather: UiWeather,
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

    val unitCode: String = if (units is TemperatureUnits.Metric) "\u2103" else "\u2109"
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = modifier
    ) {

        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.2F),
                            MaterialTheme.colorScheme.primary,
                        )
                    )
                )
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = uiWeather.cityName,
                    style = largeStyle,
                    textAlign = TextAlign.Center,
                )

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(uiWeather.iconUrl)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_default_weather),
                    error = painterResource(id = R.drawable.ic_default_weather),
                    fallback = painterResource(id = R.drawable.ic_default_weather),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
                    contentDescription = null,
                    clipToBounds = true

                )

                Text(
                    text = uiWeather.name,
                    style = mediumStyle,
                    textAlign = TextAlign.Center,
                )

                Text(
                    text = "${
                        getMetricTemperatureIn(
                            uiWeather.currentTemperature,
                            units
                        )
                    }$unitCode",
                    style = largeStyle,
                    modifier = Modifier.padding(end = 8.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "${
                        getMetricTemperatureIn(
                            uiWeather.minTemperature,
                            units
                        )
                    }$unitCode / ${
                        getMetricTemperatureIn(
                            uiWeather.maxTemperature,
                            units
                        )
                    }$unitCode",
                    style = smallStyle,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}


