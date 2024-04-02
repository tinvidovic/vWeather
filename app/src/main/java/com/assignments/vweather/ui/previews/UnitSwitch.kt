package com.assignments.vweather.ui.previews

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.assignments.presentation.components.UnitSwitch
import com.assignments.vweather.presentation.R
import com.assignments.vweather.ui.theme.VWeatherTheme

@Preview
@Composable
fun UnitSwitchPreview() {

    VWeatherTheme {
        Surface {
            UnitSwitch(text = R.string.unit_switch_label, checked = true, onCheckedChanged = {})
        }
    }
}