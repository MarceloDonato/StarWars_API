package com.marcelo.starwars_api.presentation.home.adapter

import com.marcelo.starwars_api.domain.Results
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.mechanism.utils.Utils
import kotlinx.android.synthetic.main.starwars_item.view.*

class StarWarsAdapter(
    private val items: List<Results?>
) : RecyclerView.Adapter<StarWarsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.starwars_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Results?) = with(itemView) {

            item?.let {
                Glide.with(itemView.context).load(it.url?.let { image -> Utils.getImagePeople(image) })
                    .into(image_person)
                person_name.text = it.name

            }
        }
    }
}