package com.assignments.presentation.weather

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.assignments.presentation.components.WeatherList

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {

    val state = viewModel.state

    WeatherList(
        uiWeatherList = state.uiWeatherList,
        modifier = Modifier
            .fillMaxSize()
    )
}