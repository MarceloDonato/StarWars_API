package com.marcelo.starwars_api.presentation.home.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucasdonato.pokemon_api.presentation.base.adapter.BaseRecyclerAdapter
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.domain.FilmsResults
import com.marcelo.starwars_api.mechanism.utils.Utils
import kotlinx.android.synthetic.main.starwars_item.view.*


class StarWarsRecyclerAdapter :
    BaseRecyclerAdapter<FilmsResults, StarWarsRecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(mData[position], position)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(viewGroup.context).inflate(
            (R.layout.item_films), viewGroup,
            false
        )
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(films: FilmsResults, position: Int) {


            itemView.apply {
                Glide.with(itemView.context)
                    .load(films.url?.let { image -> Utils.getImagePeople(image) })
                    .into(image_person)
                person_name.text = films.title
            }
        }
    }

    override fun validateDate() = false

}