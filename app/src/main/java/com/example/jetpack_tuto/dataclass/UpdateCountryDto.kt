package com.example.jetpack_tuto.dataclass


import com.squareup.moshi.Json

data class UpdateCountryDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "nom")
    val nom: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "id_stagiaire")
    val idStagiaire: Int
)