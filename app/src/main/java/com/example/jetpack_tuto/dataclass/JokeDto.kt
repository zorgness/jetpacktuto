package com.example.jetpack_tuto.dataclass


import com.squareup.moshi.Json

data class JokeDto(
    @Json(name = "joke")
    val joke: String
)