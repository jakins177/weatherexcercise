package com.example.weatherexercise.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherexercise.model.ForecastData
import com.example.weatherexercise.repo.remote.WeatherRepo
import com.example.weatherexercise.util.ApiState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherState = MutableLiveData<ApiState<ForecastData>>()
    val weatherState: LiveData<ApiState<ForecastData>>
        get() = _weatherState


    fun makeForecastFetch(city: String) {
        viewModelScope.launch {
            WeatherRepo.getWeatherState(city)
                .collect { weatherState -> _weatherState.postValue(weatherState) }
        }
    }
}