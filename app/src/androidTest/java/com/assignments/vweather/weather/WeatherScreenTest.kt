package com.assignments.vweather.weather

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.assignments.domain.repository.WeatherRepository
import com.assignments.domain.use_case.GetWeatherForCitiesUseCase
import com.assignments.presentation.weather.WeatherScreen
import com.assignments.presentation.weather.WeatherViewModel
import com.assignments.vweather.MainActivity
import com.assignments.vweather.repository.WeatherRepositoryFake
import com.assignments.vweather.ui.theme.VWeatherTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class WeatherScreenTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var weatherRepository: WeatherRepository
    private lateinit var getWeatherForCitiesUseCase: GetWeatherForCitiesUseCase
    private lateinit var weatherViewModel: WeatherViewModel

    @Before
    fun setUp() {

        weatherRepository = WeatherRepositoryFake()
        getWeatherForCitiesUseCase = GetWeatherForCitiesUseCase(weatherRepository)
        weatherViewModel = WeatherViewModel(getWeatherForCitiesUseCase)


        composeRule.activity.setContent {
            val snackbarHostState = remember { SnackbarHostState() }

            VWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    WeatherScreen(
                        snackbarHostState = snackbarHostState,
                        viewModel = weatherViewModel
                    )
                }
            }
        }
    }

    @Test
    fun weatherCardsExist() {

        composeRule
            .onNodeWithText("Stockholm")
            .assertExists()

        composeRule
            .onNodeWithText("London")
            .assertExists()
    }

    @Test
    fun unitSwitchTriggersUnitChange() {

        // C initially
        composeRule
            .onNodeWithText("10\u2103")
            .assertExists()

        composeRule
            .onNodeWithTag("unit_switch")
            .performClick()

        // Switch to F
        composeRule
            .onNodeWithText("50\u2109")
            .assertExists()
    }
}