package com.assignments.data.di

import android.app.Application
import androidx.room.Room
import com.assignments.data.local.WeatherDatabase
import com.assignments.data.remote.OpenWeatherApi
import com.assignments.domain.repository.WeatherRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideOpenWeatherApi(client: OkHttpClient): OpenWeatherApi {

        val moshi = Moshi.Builder() // adapter
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(OpenWeatherApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(
        api: OpenWeatherApi,
        db: WeatherDatabase
    ): WeatherRepository {

        return com.assignments.data.repository.WeatherRepository(
            api = api,
            dao = db.dao
        )
    }

    @Provides
    @Singleton
    fun provideWeatherDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(
            app,
            WeatherDatabase::class.java,
            "weather_db"
        ).build()
    }
}