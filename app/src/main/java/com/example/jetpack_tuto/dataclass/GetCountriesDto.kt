package com.example.jetpack_tuto.dataclass


import com.example.jetpack_tuto.dataclass.CountryDto
import com.squareup.moshi.Json

data class GetCountriesDto(
    @Json(name = "status")
    val status: String,
    @Json(name = "countries")
    val countries: List<CountryDto> = listOf()
)