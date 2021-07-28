package com.marcelo.starwars_api.presentation.home.view

import com.marcelo.starwars_api.domain.FilmsResults
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.presentation.home.adapter.FilmsAdapter
import com.marcelo.starwars_api.presentation.home.adapter.StarWarsRecyclerAdapter
import com.marcelo.starwars_api.presentation.home.view_model.HomeViewModel
import com.marcelo.starwars_api.presentation.home.view_model.StarWarsViewModelFactory
import kotlinx.android.synthetic.main.activity_films_acitivity.*


class FilmsAcitivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, FilmsAcitivity::class.java)
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
        setContentView(R.layout.activity_films_acitivity)

        observable()
        setupRecyclerView()

    }

    private fun observable() {
        viewModel.films.observe(this, Observer {
            adapterList.data = it.toMutableList()
        })
    }


    private fun setupRecyclerView() {

        rvFilms.apply {
            adapter = adapterList
            isFocusable = false
            adapterList.onItemClickListener = {
                //       startActivity(PokemonDetailsActivity.getStartIntent(context, it))
            }


        }
    }
}