package com.marcelo.starwars_api.presentation.home.view

import com.marcelo.starwars_api.domain.FilmsResults
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.mechanism.EXTRA_ID


class HomeActivity : AppCompatActivity() {


    companion object {
        fun getStartIntent(context: Context, filmsResults: FilmsResults): Intent =
            Intent(context, HomeActivity::class.java).apply {
                putExtra(EXTRA_ID, filmsResults)
            }
    }

    private lateinit var filmsData: FilmsResults



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun receiveData() {
        filmsData = (intent?.getSerializableExtra(EXTRA_ID) as FilmsResults?)!!
        filmsData.also {

        }
    }
}

