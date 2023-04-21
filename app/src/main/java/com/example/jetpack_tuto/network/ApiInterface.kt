package com.example.jetpack_tuto.network

import com.example.jetpack_tuto.dataclass.GetCountriesDto
import com.example.jetpack_tuto.dataclass.GetCountryDto
import com.example.jetpack_tuto.dataclass.RetourDto
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @GET(ApiRoutes.GET_ALL_COUNTRY)
    fun getAllCountry(@Query("id_s") idStagiaire: Long): Call<GetCountriesDto>?

    @GET(ApiRoutes.GET_COUNTRY)
    fun getCountry(@Query("id") idPays: Long): Call<GetCountryDto>?

    @FormUrlEncoded
    @POST(ApiRoutes.ADD_COUNTRY)
    fun addCountry(@Field("id_s") idStagiaire: Long,
                   @Field("nom") name: String,
                   @Field("url") url: String
    ): Call<RetourDto>?


  /*  @POST(ApiRoutes.UPDATE_COUNTRY)
    fun updateCountry(@Body updatedCountry: UpdateCountryDto): Call<RetourDto>?*/


    @FormUrlEncoded
    @POST(ApiRoutes.DELETE_COUNTRY)
    fun deleteCountry(@Field("id") idCountry: Long): Call<RetourDto>?


}













