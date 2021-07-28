package com.marcelo.starwars_api.presentation.home.view_model

import com.marcelo.starwars_api.domain.FilmsResults
import com.marcelo.starwars_api.domain.Results
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcelo.starwars_api.api.model.StarWarsRepository

class HomeViewModel : ViewModel() {
    var people = MutableLiveData<List<Results?>>()
    var films = MutableLiveData<List<FilmsResults>>()

    init {
        Thread(Runnable {
            getStarWarsFilms()
        }).start()
    }

    fun startStarWars() {
        val starWarsApiResult = StarWarsRepository.getStartListPeople()
        starWarsApiResult?.results.let {
            people.postValue(it)
        }
    }

    private fun getStarWarsFilms() {
        val filmsApiResults = StarWarsRepository.getListFilms()
        filmsApiResults?.results.let {
            films.postValue(it)
        }
    }
}
