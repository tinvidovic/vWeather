package com.assignments.presentation.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.domain.use_case.GetWeatherForCitiesUseCase
import com.assignments.presentation.mapper.toUiWeather
import com.assignments.presentation.weather.WeatherViewModel.Constants.cityNames
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherForCitiesUseCase: GetWeatherForCitiesUseCase
): ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    init {

        loadWeather(
            cityNames = cityNames,
            units = getTemperatureUnits()
        )
    }

    fun onEvent(event: WeatherEvent) {

        when (event) {
            is WeatherEvent.OnUnitCheckedChanged -> {
                state = state.copy(
                    unitSwitchChecked = state.unitSwitchChecked.not(),
                    // Reset the list and fetch, this serves as a make-shift refresh
                    uiWeatherList = emptyList()
                )

                loadWeather(
                    cityNames,
                    getTemperatureUnits()
                )
            }

            WeatherEvent.OnWeatherListRefresh -> {

                state = state.copy(
                    isRefreshing = true
                )

                loadWeather(
                    cityNames,
                    getTemperatureUnits()
                )
            }
        }
    }

    private fun loadWeather(
        cityNames: List<String>,
        units: TemperatureUnits
    ) {

        viewModelScope.launch {
            getWeatherForCitiesUseCase(cityNames, units)
                .onSuccess {weatherList ->
                    state = state.copy(
                        uiWeatherList = weatherList.map {
                            it.toUiWeather()
                        },
                        isRefreshing = false
                    )
                }.onFailure {
                    state = state.copy(
                        isRefreshing = false
                    )

                    it.printStackTrace()
                }
        }
    }

    fun getTemperatureUnits(): TemperatureUnits {

        // NOTE: This would also likely be loaded from some kind of preferences
        return if (state.unitSwitchChecked) TemperatureUnits.Metric() else return TemperatureUnits.Imperial()
    }

    private object Constants {

        // NOTE: These would come from a shared preferences in a real app, but since there
        // is no mechanism to add/remove cities in this assignment, they are hardcoded here
        val cityNames = listOf(
            "Gothenburg",
            "Stockholm",
            "Mountain View",
            "London",
            "New York",
            "Berlin",
        )
    }
}