package com.example.whatmovietosee.movie_details.presentation

import ImagesResponse
import MovieDetails
import VideosResponse
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatmovietosee.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity(), MovieDetailsView {
    private var presenter= MovieDetailsPresenterImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieId: Int = intent.getIntExtra("MOVIE_ID", 0)
        presenter.attachView(this)
        presenter.onViewAttached(movieId)

    }

    override fun showMovieDetails(movieDetails: MovieDetails) {
        Picasso.get()
            .load(movieDetails.posterPath)
            .into(movieDetailsCover)

        movieDetailsTitle.text = movieDetails.title
        movieDetailsSubtitle.text = "Дата релиза: "+movieDetails.releaseDate
        movieDetailsDescription.text = "Описание фильма: "+movieDetails.overview
        movieDetailsRating.text = movieDetails.voteAverage!!.toString()+"/10.0"
        movieDetailsRatingBar.rating=movieDetails.voteAverage.toFloat()
    }

    override fun showImages(imagesResponse: ImagesResponse) {
        val backdrops = imagesResponse.backdrops
        if (backdrops.isNotEmpty()) {
            viewPager2.adapter =
                ViewPagerAdapter(
                    backdrops
                )
        }
    }

    override fun showVideos(videosResponse: VideosResponse) {
        val results = videosResponse.results
        movieDetailsWatchTrailer.setOnClickListener {
            if (results.isNotEmpty()) {
                val youtubeVideoId = results[0].key
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=${youtubeVideoId}")
                )
                startActivity(intent)
            } else {
                Toast.makeText(this@MovieDetailsActivity, "Трейлер не найден", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}