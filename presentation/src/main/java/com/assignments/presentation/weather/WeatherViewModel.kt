package com.assignments.presentation.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.domain.repository.util.Resource
import com.assignments.domain.use_case.GetWeatherForCitiesUseCase
import com.assignments.presentation.mapper.toUiWeather
import com.assignments.presentation.util.UIEvent
import com.assignments.presentation.weather.WeatherViewModel.Constants.cityNames
import com.assignments.vweather.presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherForCitiesUseCase: GetWeatherForCitiesUseCase,
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {

        loadWeather(
            cityNames = cityNames
        )
    }

    fun onEvent(event: WeatherEvent) {

        when (event) {
            is WeatherEvent.OnUnitCheckedChanged -> {
                state = state.copy(
                    unitSwitchChecked = state.unitSwitchChecked.not(),
                )
            }

            WeatherEvent.OnWeatherListRefresh -> {

                state = state.copy(
                    isRefreshing = true
                )

                loadWeather(
                    cityNames
                )
            }
        }
    }

    private fun loadWeather(
        cityNames: List<String>,
    ) {

        viewModelScope.launch {
            val result = getWeatherForCitiesUseCase(cityNames)

            state = state.copy(
                isRefreshing = false
            )

            when (result) {
                is Resource.Error -> {
                    _uiEvent.send(
                        UIEvent.ShowSnackbar(R.string.loading_error)
                    )
                }

                is Resource.Success -> {
                    println("Resource.Success")
                }
            }

            result.data?.collectLatest { weathers ->

                state = state.copy(
                    uiWeatherList = weathers.map {
                        it.toUiWeather()
                    },
                )
            }
        }
    }

    /**
     * Returns the [TemperatureUnits] based on the state of the switch
     */
    fun getTemperatureUnits(): TemperatureUnits {

        // NOTE: This would also likely be loaded from some kind of preferences
        return if (state.unitSwitchChecked) TemperatureUnits.Imperial() else return TemperatureUnits.Metric()
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