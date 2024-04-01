package com.assignments.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assignments.data.local.entity.WeatherEntity

@Database(
    entities = [WeatherEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WeatherDatabase: RoomDatabase() {
    abstract val dao: WeatherDao
}