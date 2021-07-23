package com.marcelo.starwars_api.presentation.home.view_model

import Results
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcelo.starwars_api.api.model.StarWarsRepository

class HomeViewModel : ViewModel() {
    var people = MutableLiveData<List<Results?>>()
    var listAdd = MutableLiveData<List<Results?>>()

    init {
        Thread(Runnable {
            startStarWars()
        }).start()
    }

    fun startStarWars() {
        val starWarsApiResult = StarWarsRepository.getStartListPeople()
        starWarsApiResult?.results.let {
            people.postValue(it)
        }
    }

    fun starWarsPage(page: Int) {
        val starWarsApiResult = StarWarsRepository.getListPeople(page)
        starWarsApiResult?.results?.let {
            listAdd.postValue(it)
        }
    }
}
