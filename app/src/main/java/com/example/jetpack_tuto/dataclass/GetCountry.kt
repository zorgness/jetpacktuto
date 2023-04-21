package com.example.jetpack_tuto.dataclass


import com.squareup.moshi.Json

data class GetCountryDto(
    @Json(name = "status")
    val status: String,
    @Json(name = "country")
    val country: CountryDto?
)