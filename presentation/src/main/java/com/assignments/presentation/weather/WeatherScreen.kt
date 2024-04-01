package com.assignments.presentation.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.assignments.presentation.components.UnitSwitch
import com.assignments.presentation.components.WeatherList
import com.assignments.vweather.presentation.R

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        WeatherList(
            uiWeatherList = state.uiWeatherList,
            units = viewModel.getTemperatureUnits(),
            isRefreshing = state.isRefreshing,
            onRefresh = { viewModel.onEvent(WeatherEvent.OnWeatherListRefresh) },
            modifier = Modifier
                .weight(1F, false)
        )

        UnitSwitch(
            text = R.string.unit_switch_label,
            checked = state.unitSwitchChecked,
            onCheckedChanged = {
                viewModel.onEvent(WeatherEvent.OnUnitCheckedChanged(it))
            },
        )
    }
}