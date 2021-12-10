package com.example.weatherexercise.repo.remote

import android.util.Log
import com.example.weatherexercise.model.ForecastData
import com.example.weatherexercise.util.ApiState
import kotlinx.coroutines.flow.flow

object WeatherRepo {

    private const val TAG = "WeatherRepo"

    private const val api_key = "65d00499677e59496ca2f318eb68c049"
    private const val units = "imperial"

    private val weatherService by lazy { RetrofitInstance.weatherService }

    fun getWeatherState(
        city: String
    ) = flow<ApiState<ForecastData>> {
        emit(ApiState.Loading)

        val state =
            if (true) {
                val weatherResponse = weatherService.getForecastByCity(city, api_key, units)

                if (weatherResponse.isSuccessful) {

                    Log.i(TAG, "weatherResponse response body is : ${weatherResponse.body()} ")
                    ApiState.Success(weatherResponse.body()!!)
                } else {
                    ApiState.Failure("Error fetching data.")
                }

            } else {
                ApiState.Error("Unknown error fetching API")
            }
        emit(state)
    }
}