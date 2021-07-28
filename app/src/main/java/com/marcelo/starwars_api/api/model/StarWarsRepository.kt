package com.marcelo.starwars_api.api.model

import com.marcelo.starwars_api.domain.Films
import com.marcelo.starwars_api.domain.People
import com.marcelo.starwars_api.api.model.StarWarsRepository.HTTPLogger.getLogger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StarWarsRepository {
    private val service: StarWarsService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getLogger())
            .build()

        getLogger()
        service = retrofit.create(StarWarsService::class.java)
    }

    object HTTPLogger {
        fun getLogger(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }
    }

    fun getStartListPeople(): People? {
        val call = service.getPeople()
        return call.execute().body()
    }

    fun getListFilms(): Films? {
        val call = service.getFilms()
        return call.execute().body()
    }


}