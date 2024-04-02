package com.assignments.domain.di

import com.assignments.domain.repository.WeatherRepository
import com.assignments.domain.use_case.GetWeatherForCitiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideGetWeatherForCitiesUseCase(
        weatherRepository: WeatherRepository
    ): GetWeatherForCitiesUseCase {

        return GetWeatherForCitiesUseCase(
            weatherRepository = weatherRepository
        )
    }
}