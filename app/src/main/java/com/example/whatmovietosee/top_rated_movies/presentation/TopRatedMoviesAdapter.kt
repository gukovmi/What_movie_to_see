package com.example.whatmovietosee.top_rated_movies.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatmovietosee.R
import com.example.whatmovietosee.domain.entity.TopRated.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_movie.view.*



class TopRatedMoviesAdapter (private val movies: List<Movie>,
                             private val rowLayout: Int,
                             val clickListener: (Movie) -> Unit
): RecyclerView.Adapter<TopRatedMoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(v:View): RecyclerView.ViewHolder(v) {

//        internal var movieTitle: TextView = v.findViewById(R.id.title)
//        internal var data: TextView = v.findViewById(R.id.subtitle)
//        internal var movieDescription: TextView = v.findViewById(R.id.description)
//        internal var rating: TextView = v.findViewById(R.id.rating)
//        internal var cover = v.findViewById<AppCompatImageView>(R.id.cover)

        fun bindMovie(movie: Movie, clickListener: (Movie) -> Unit) {
            itemView.apply {
                title.text = movie.title
                subtitle.text = movie.releaseDate
                description.text = movie.overview
                rating.text = movie.voteAverage!!.toString()

                Picasso.get()
                    .load(movie.posterPath)
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(cover)

                setOnClickListener { clickListener(movie) }

            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return MovieViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        //val current = movies[position]
        holder.bindMovie(movie= movies[position], clickListener = clickListener)



    }


}