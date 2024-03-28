package com.assignments.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.assignments.presentation.model.Weather
import com.assignments.vweather.presentation.R

@Composable
fun WeatherCard(
    weather: Weather,
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
        ){

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = modifier
                    .padding(
                        horizontal = 8.dp,
                        vertical = 8.dp
                    )
            ) {

                Column{

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = weather.cityName, style = largeStyle, modifier = Modifier.padding(end = 8.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = stringResource(id = R.string.location_cd),
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(32.dp),
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Text(
                            text = "${weather.currentTemperature}\u00B0",
                            style = largeStyle,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = weather.name,
                            style = mediumStyle,
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "${weather.maxTemperature}\u00B0 / ${weather.minTemperature}\u00B0 Feels like: ${weather.subjectiveTemperature}\u00B0",
                            style = smallStyle,
                        )
                    }
                }

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(weather.iconUrl)
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
            }

        }
    }
}

