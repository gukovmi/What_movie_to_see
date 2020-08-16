package com.example.whatmovietosee.top_rated_movies.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatmovietosee.R
import com.example.whatmovietosee.domain.entity.TopRated.Movie
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import com.example.whatmovietosee.movie_details.presentation.MovieDetailsActivity
import kotlinx.android.synthetic.main.activity_top_movies.*

class TopRatedMoviesActivity : AppCompatActivity(), TopRatedMoviesView {

    private var presenter=TopRatedMoviesPresenterImpl()
    private var topRatedMoviesAdapter: TopRatedMoviesAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_movies)

        presenter.attachView(this)
    }

    override fun showTopRatedMovies(topRatedResponse: TopRatedResponse) {
        val topRatedMovies = topRatedResponse.results
        if (topRatedMovies.isEmpty()) {
            Toast.makeText(this, "Movies list is empty!", Toast.LENGTH_LONG).show()
        } else {
            val recyclerView = topRatedMoviesRecyclerView
            recyclerView.layoutManager=LinearLayoutManager(this@TopRatedMoviesActivity)
            recyclerView.adapter = TopRatedMoviesAdapter(
                topRatedMovies,
                R.layout.list_item_movie,
                { movie: Movie -> presenter.onMovieItemClick(movie) }
            )
            pageNumber.text=topRatedResponse.page.toString()
            nextPageButton.setOnClickListener {
                presenter.nextPage(topRatedResponse)
            }
            previousPageButton.setOnClickListener {
                presenter.previousPage(topRatedResponse)
            }
        }
    }

    override fun navigateToMovieDetails(movie: Movie) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("MOVIE_ID", movie.id)
        startActivity(intent)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
