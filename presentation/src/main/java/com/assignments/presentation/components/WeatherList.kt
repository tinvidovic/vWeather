package com.assignments.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.assignments.domain.repository.TemperatureUnits
import com.assignments.presentation.model.UiWeather

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherList(
    uiWeatherList: List<UiWeather>,
    units: TemperatureUnits,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
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
    lazyListState: LazyListState = rememberLazyListState(),
) {

    val pullToRefreshState = rememberPullToRefreshState()

    Box(
        modifier = modifier
            .nestedScroll(pullToRefreshState.nestedScrollConnection)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = lazyListState,
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(uiWeatherList) { weather ->

                WeatherCard(
                    uiWeather = weather,
                    largeStyle = largeStyle,
                    mediumStyle = mediumStyle,
                    smallStyle = smallStyle,
                    units = units,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }

        if(pullToRefreshState.isRefreshing) {
            LaunchedEffect(true) {
                onRefresh()
            }
        }

        LaunchedEffect(isRefreshing) {
            if(isRefreshing) {
                pullToRefreshState.startRefresh()
            } else {
                pullToRefreshState.endRefresh()
            }
        }

        PullToRefreshContainer(
            state = pullToRefreshState,
            modifier = Modifier
                .align(Alignment.TopCenter),
        )
    }


}