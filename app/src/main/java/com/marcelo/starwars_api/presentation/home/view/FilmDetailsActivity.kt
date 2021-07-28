package com.marcelo.starwars_api.presentation.home.view

import com.marcelo.starwars_api.domain.FilmsResults
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.mechanism.EXTRA_ID
import com.marcelo.starwars_api.mechanism.utils.Utils
import kotlinx.android.synthetic.main.include_films_details_description.*
import kotlinx.android.synthetic.main.include_films_details_image.*

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

            Glide.with(this).load(it.url.let { image -> Utils.getImageFilms(image) })
                .into(image_details_film)

            film_details_name.text = it.title
            film_opening_crawl.text = getString(R.string.opening_craw, it.opening_crawl)
            film_director_name.text = getString(R.string.name_director, it.director)
            film_producer_name.text = getString(R.string.name_producer, it.producer)

        }
    }
}
