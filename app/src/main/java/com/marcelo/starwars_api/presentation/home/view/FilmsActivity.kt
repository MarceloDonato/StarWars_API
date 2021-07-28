package com.marcelo.starwars_api.presentation.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.domain.FilmsResults
import com.marcelo.starwars_api.presentation.home.adapter.StarWarsRecyclerAdapter
import com.marcelo.starwars_api.presentation.home.view_model.HomeViewModel
import com.marcelo.starwars_api.presentation.home.view_model.StarWarsViewModelFactory
import kotlinx.android.synthetic.main.activity_films.*

class FilmsActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, FilmsActivity::class.java)
    }

    private val adapterList: StarWarsRecyclerAdapter by lazy {
        StarWarsRecyclerAdapter()
    }

    private val viewModel by lazy {
        ViewModelProvider(this, StarWarsViewModelFactory())
            .get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)
        observable()
    }

    private fun observable() {
        viewModel.films.observe(this, Observer {
            setupRecyclerView(it)
        })
    }

    private fun setupRecyclerView(films: List<FilmsResults?>) {
        adapterList.data = films.toMutableList()
        rvFilms.apply {
            adapter = adapterList
            isFocusable = false
            adapterList.onItemClickListener = {
                startActivity(it?.let { film -> FilmDetailsActivity.getStartIntent(context, film) })
            }
        }
        if (films.isNotEmpty()) loader.visibility = GONE
    }

}