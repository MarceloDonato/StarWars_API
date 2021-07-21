package com.marcelo.starwars_api.viewmodel

import Results
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcelo.starwars_api.api.model.StarWarsRepository


class StarWarsViewModel : ViewModel() {
    var people = MutableLiveData<List<Results?>>()

    init {
        Thread(Runnable {
            loadStarWars()
        }).start()
    }


    private fun loadStarWars() {

        val starWarsApiResult = StarWarsRepository.getListPeople(1)
        starWarsApiResult?.let{
        //    people = it.results
        }

    }
}
