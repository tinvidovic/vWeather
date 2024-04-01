package com.assignments.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.assignments.domain.repository.TemperatureUnits
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
        ){

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
                    text = "${uiWeather.currentTemperature}$unitCode",
                    style = largeStyle,
                    modifier = Modifier.padding(end = 8.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "${uiWeather.maxTemperature}$unitCode / ${uiWeather.minTemperature}$unitCode",
                    style = smallStyle,
                    textAlign = TextAlign.Center
                )
            }

            /*Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 8.dp
                    )
            ) {

                Column(
                    modifier = Modifier
                        .weight(1F)
                ){

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = uiWeather.cityName, style = largeStyle, modifier = Modifier.padding(end = 8.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = stringResource(id = R.string.location_cd),
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(24.dp),
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Bottom
                    ) {

                        Text(
                            text = "${uiWeather.currentTemperature}$unitCode",
                            style = largeStyle,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = uiWeather.name,
                            style = mediumStyle,
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "${uiWeather.maxTemperature}$unitCode / ${uiWeather.minTemperature}$unitCode",
                            style = smallStyle,
                        )
                    }
                }

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
                    modifier = Modifier
                        .padding(
                            start = 16.dp
                        )
                        .size(68.dp)

                )
            }*/

        }
    }
}


