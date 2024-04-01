package com.assignments.presentation.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.assignments.presentation.components.UnitSwitch
import com.assignments.presentation.components.WeatherList
import com.assignments.presentation.util.UIEvent
import com.assignments.vweather.presentation.R

@Composable
fun WeatherScreen(
    snackbarHostState: SnackbarHostState,
    viewModel: WeatherViewModel = hiltViewModel()
) {

    val state = viewModel.state

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = context.getString(event.messageId)
                    )
                }
            }
        }
    }

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