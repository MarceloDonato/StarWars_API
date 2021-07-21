package com.marcelo.starwars_api.view

import Results
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marcelo.starwars_api.R
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
                // Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)
                itemView.peopleName.text= it.name


            }
        }
    }
}