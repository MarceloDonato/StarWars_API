package com.marcelo.starwars_api.api.model

import People
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.marcelo.starwars_api.BuildConfig
import com.marcelo.starwars_api.api.model.StarWarsRepository.HTTPLogger.getLogger
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object StarWarsRepository {
    private val service: StarWarsService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(HTTPLogger.getLogger())
            .build()

        getLogger()
        service = retrofit.create(StarWarsService::class.java)
    }

    object HTTPLogger {
        fun getLogger(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            return client
        }
    }

    fun getStartListPeople (): People? {
        val call = service.getPeople()
        return call.execute().body()
    }

    fun getListPeople (page: Int ): People? {
        val call = service.getListPeople(page)
        return call.execute().body()
    }

}