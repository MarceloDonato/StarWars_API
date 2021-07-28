package com.marcelo.starwars_api.presentation.home.adapter

import com.marcelo.starwars_api.domain.FilmsResults
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcelo.starwars_api.R
import com.marcelo.starwars_api.mechanism.utils.Utils
import kotlinx.android.synthetic.main.item_films.view.*


class FilmsAdapter(

    private val items: List<FilmsResults?>
) : RecyclerView.Adapter<FilmsAdapter.ViewHolder>() {

    var onItemClickListener: ((item: FilmsResults) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_films, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var onItemClickListener: ((item: FilmsResults) -> Unit)? = null

        fun bindView(item: FilmsResults?) = with(itemView) {

            item?.let {
                Glide.with(itemView.context)
                    .load(it.url?.let { image -> Utils.getImageFilms(image) }).into(image_film)
                film_name.text = it.title
                container.setOnClickListener {
                    onItemClickListener?.invoke(item)
                }

            }
        }
    }
}
