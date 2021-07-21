package com.marcelo.starwars_api.view

import Results
import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.viewmodel.StarWarsViewModel
import com.marcelo.starwars_api.viewmodel.StarWarsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvStarWars)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, StarWarsViewModelFactory())
            .get(StarWarsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.people.observe(this, Observer {
            loadRecyclerView(it)
        })

    }
    private fun loadRecyclerView(people : List<Results?>){

        loader_starwars.visibility = VISIBLE

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StarWarsAdapter(people)

        loader_starwars.visibility = GONE
    }
}