package com.marcelo.starwars_api.api.model

import com.marcelo.starwars_api.domain.Films
import com.marcelo.starwars_api.domain.People
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsService {

    @GET("people/")
    fun getPeople(): Call<People>

    @GET("people/")
    fun getListPeople(@Query("page") page: Int): Call<People>

    @GET("films")
    fun getFilms(): Call<Films>


}