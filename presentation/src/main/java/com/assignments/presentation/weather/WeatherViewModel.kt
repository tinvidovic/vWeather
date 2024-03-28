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
import com.assignments.presentation.weather.WeatherViewModel.Constants.units
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

        loadWeather(cityNames = cityNames)
    }

    private fun loadWeather(
        cityNames: List<String>
    ) {

        viewModelScope.launch {
            getWeatherForCitiesUseCase(cityNames, units)
                .onSuccess {weatherList ->
                    state = state.copy(
                        uiWeatherList = weatherList.map {
                            it.toUiWeather()
                        }
                    )
                }.onFailure {
                    it.printStackTrace()
                }
        }
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

        val units = TemperatureUnits.Metric()
    }
}