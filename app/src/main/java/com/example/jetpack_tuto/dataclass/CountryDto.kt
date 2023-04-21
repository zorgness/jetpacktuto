package com.example.jetpack_tuto.dataclass


import com.squareup.moshi.Json

data class CountryDto(
    @Json(name = "id_pays")
    val idPays: Int,
    @Json(name = "nom")
    val nom: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "id_stagiaire")
    val idStagiaire: Int
)