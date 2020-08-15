package com.example.whatmovietosee.modules.movie_details.adapters

import Backdrops
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatmovietosee.R
import kotlinx.android.synthetic.main.item_photo.view.*


class ViewPagerAdapter(val backdrops : List<Backdrops>) : RecyclerView.Adapter<PagerVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false))

    override fun getItemCount(): Int = backdrops.size

    override fun onBindViewHolder(holder: PagerVH, position: Int): Unit = holder.itemView.run {
        //photoNumber.text = "Photo ${position+1}/${getItemCount()}"
        Glide
            .with(this)
            .load("https://image.tmdb.org/t/p/w533_and_h300_bestv2"+backdrops[position].filePath)
            .into(photoView)
    }
}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)