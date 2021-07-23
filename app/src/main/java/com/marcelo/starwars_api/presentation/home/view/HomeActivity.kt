package com.marcelo.starwars_api.presentation.home.view

import Results
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.mechanism.pagination.currency.PaginationListener
import com.marcelo.starwars_api.presentation.home.adapter.StarWarsAdapter
import com.marcelo.starwars_api.presentation.home.view_model.HomeViewModel
import com.marcelo.starwars_api.presentation.home.view_model.StarWarsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    var list = mutableListOf<Results?>()

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvStarWars)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, StarWarsViewModelFactory())
            .get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observable()
    }

    private fun observable() {
        viewModel.people.observe(this, Observer {
            list.addAll(it)
            loadRecyclerView(list)
        })

//        viewModel.listAdd.observe(this, Observer {
//            list.addAll(it)
//        })
    }

    private fun loadRecyclerView(people: List<Results?>) {
        recyclerView.apply {
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = StarWarsAdapter(people)

//            addOnScrollListener(object :
//                PaginationListener(layoutManager as LinearLayoutManager, limitRecycler) {
//                override fun loadMoreItems() {
//                    limitRecycler++
//                    viewModel.starWarsPage(limitRecycler)
//                }
//
//                override val isLoading: Boolean
//                    get() = loader_starwars.visibility == VISIBLE
//
//            })
        }
    }
}