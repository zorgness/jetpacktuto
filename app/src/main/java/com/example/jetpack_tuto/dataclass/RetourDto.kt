package com.example.jetpack_tuto.dataclass


import com.squareup.moshi.Json

data class RetourDto(
    @Json(name = "retour")
    val retour: Int
)