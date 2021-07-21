package com.marcelo.starwars_api.api.model

import People
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StarWarsRepository {
    private val service: StarWarsService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(StarWarsService::class.java)
    }

    fun getListPeople (page: Int ): People? {
        val call = service.getPeople(page)

        return call.execute().body()
    }


}