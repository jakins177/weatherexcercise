package com.example.weatherexercise.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ForecastData(
    @Json(name = "city")
    val city: City?,
    @Json(name = "cnt")
    val cnt: Double?,
    @Json(name = "cod")
    val cod: String?,
    @Json(name = "list")
    val list: List<ForecastDetails>?,
    @Json(name = "message")
    val message: Double?
): Parcelable