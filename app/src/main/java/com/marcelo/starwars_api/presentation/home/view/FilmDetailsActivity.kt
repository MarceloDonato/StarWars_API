package com.marcelo.starwars_api.presentation.home.view

import com.marcelo.starwars_api.domain.FilmsResults
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.mechanism.EXTRA_ID
import kotlinx.android.synthetic.main.activity_film_details.*


class FilmDetailsActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, filmsResults: FilmsResults): Intent =
            Intent(context, FilmDetailsActivity::class.java).apply {
                putExtra(EXTRA_ID, filmsResults)
            }
    }

    private lateinit var filmsData: FilmsResults

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_details)
        receiveData()
    }

    private fun receiveData() {
        filmsData = intent?.getSerializableExtra(EXTRA_ID) as FilmsResults

        filmsData.also {

            film_details_name.text = it.title
            film_details_director.text = getString(R.string.name_director, it.director)

        }
    }
}

