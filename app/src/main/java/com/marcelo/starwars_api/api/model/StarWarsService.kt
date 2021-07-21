package com.marcelo.starwars_api.api.model

import People
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsService {
    @GET("people")
    fun getPeople(@Query("page") page: Int): Call<People>


}