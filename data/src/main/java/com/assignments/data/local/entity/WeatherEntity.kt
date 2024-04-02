package com.assignments.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A DB entity representing a city weather
 * @see README
 */
@Entity(
    tableName = "weathers"
)
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val latitude: Float,
    val longitude: Float,
    val weatherId: Int,
    val weatherMain: String,
    val weatherDescription: String,
    val weatherIcon: String,
    val mainTemperature: Float?,
    val mainPressure: Int?,
    val mainHumidity: Int?,
    val mainMinTemperature: Float?,
    val mainMaxTemperature: Float?,
    val visibility: Int,
    val name: String
)