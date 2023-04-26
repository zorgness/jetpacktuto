package com.example.jetpack_tuto.network2

import com.example.jetpack_tuto.dataclass.JokeDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api")
    suspend fun getResponseJoke(@Query("format") format: String): Response<JokeDto>?
}