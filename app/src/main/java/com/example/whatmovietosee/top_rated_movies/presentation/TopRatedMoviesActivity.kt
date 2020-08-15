package com.example.whatmovietosee.top_rated_movies.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatmovietosee.R
import com.example.whatmovietosee.data.ApiCallback
import com.example.whatmovietosee.domain.entity.TopRated.Movie
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import com.example.whatmovietosee.modules.movie_details.MovieDetailsActivity
import com.example.whatmovietosee.data.Constants
import com.example.whatmovietosee.network.MovieApiClient
import com.example.whatmovietosee.top_rated_movies.di.TopRatedMoviesModelFactory
import com.example.whatmovietosee.top_rated_movies.domain.TopRatedMoviesModel
import kotlinx.android.synthetic.main.activity_top_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedMoviesActivity : AppCompatActivity(), TopRatedMoviesView {

    private lateinit var presenter: TopRatedMoviesPresenter
    private var topRatedMoviesAdapter: TopRatedMoviesAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_movies)


        presenter=TopRatedMoviesPresenterImpl(this)
        presenter.onViewAttached()
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
        intent.putExtra("MOVIE_ID", movie.id?.toString())
        startActivity(intent)
    }

}
