package com.marcelo.starwars_api.api.model

import People
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryName

interface StarWarsService {

    @GET("people/")
    fun getPeople(): Call<People>

    @GET("people/")
    fun getListPeople(@Query("page") page: Int): Call<People>

}