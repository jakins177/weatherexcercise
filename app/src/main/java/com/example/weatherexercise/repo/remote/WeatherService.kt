package com.example.weatherexercise.repo.remote

import com.example.weatherexercise.model.ForecastData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/forecast")
    suspend fun getForecastByCity(
        @Query("q") q: String,
        @Query("appid") appid: String,
        @Query("units") units: String

    ): Response<ForecastData>

}