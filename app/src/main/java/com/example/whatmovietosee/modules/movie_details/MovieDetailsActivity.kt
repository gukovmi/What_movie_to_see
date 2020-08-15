package com.example.whatmovietosee.modules.movie_details

import ImagesResponse
import MovieDetails
import VideosResponse
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatmovietosee.R
import com.example.whatmovietosee.modules.movie_details.adapters.ViewPagerAdapter
import com.example.whatmovietosee.data.Constants
import com.example.whatmovietosee.network.MovieApiClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsActivity : AppCompatActivity() {
    private val movieId: String
        get() { return intent.getStringExtra("MOVIE_ID")}
    var youtubeVideoId: String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        //Toast.makeText(this, movieId, Toast.LENGTH_LONG).show()
        makeCall()


    }

    fun makeCall() {
        val movieId=movieId.toInt()
        Log.i("id", movieId.toString())
        val call: Call<MovieDetails> = MovieApiClient.apiClient.getMovieById(movieId, Constants.API_KEY, "ru")

        call.enqueue(object : Callback<MovieDetails> {
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                Log.e("ERROR!", t.toString())
            }

            override fun onResponse(
                call: Call<MovieDetails>,
                response: Response<MovieDetails>
            ) {
                val movieDetails=response.body()

                Log.i("Title", movieDetails!!.title)
                //Log.i("Title", movieDetails.posterPath)

                Picasso.get()
                    .load(movieDetails.posterPath)
                    //.centerCrop()
                    //.placeholder(R.drawable.ic_launcher_foreground)
                    .into(movieDetailsCover)

//                Picasso.get()
//                    .load("https://image.tmdb.org/t/p/w533_and_h300_bestv2"+movieDetails.backdropPath)
//                    .into(object : Target {
//                        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
//                        }
//
//                        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
//                        }
//
//                        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
//                            //window.setBackgroundDrawable(BitmapDrawable(resources, bitmap))
//                            moviesLayout.background=BitmapDrawable(resources, bitmap)
//
//                        }
//
//                    })

                movieDetailsTitle.text = movieDetails.title
                movieDetailsSubtitle.text = "Дата релиза: "+movieDetails.releaseDate
                movieDetailsDescription.text = "Описание фильма: "+movieDetails.overview
                movieDetailsRating.text = movieDetails.voteAverage!!.toString()+"/10.0"
                movieDetailsRatingBar.rating=movieDetails.voteAverage.toFloat()

                makeCallImages()

                movieDetailsWatchTrailer.setOnClickListener {
//                    val intent = Intent(this@MovieDetailsActivity, YoutubeActivity::class.java)
//                    intent.putExtra("MOVIE_ID", movieId)
//                    startActivity(intent)
                    makeCallVideos()
                }



            }


        }

        )
    }
    fun makeCallVideos():String? {
        val movieId=movieId.toInt()
        Log.i("id", movieId.toString())
        val call: Call<VideosResponse> = MovieApiClient.apiClient.getVideosById(movieId, Constants.API_KEY, "ru")

        call.enqueue(object : Callback<VideosResponse> {
            override fun onFailure(call: Call<VideosResponse>, t: Throwable) {
                Log.e("ERROR!", t.toString())
            }

            override fun onResponse(
                call: Call<VideosResponse>,
                response: Response<VideosResponse>
            ) {
                val results = response.body()?.results
                if (results!!.isNotEmpty()) {
                    Log.i("results", results?.get(0)?.key)
                    youtubeVideoId = results?.get(0)?.key
                    if (youtubeVideoId!=null) {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/watch?v=${youtubeVideoId}")
                        )
                        startActivity(intent)
                    }

                }
                else {
                    //Log.i("results", movieId.toString())
                    Toast.makeText(this@MovieDetailsActivity, "Трейлер не найден", Toast.LENGTH_LONG).show()
                }
            }
        })
        return youtubeVideoId
    }
    fun makeCallImages() {
        val movieId=movieId.toInt()
        Log.i("idfromimage", movieId.toString())
        val call: Call<ImagesResponse> = MovieApiClient.apiClient.getImagesById(movieId, Constants.API_KEY)

        call.enqueue(object : Callback<ImagesResponse> {
            override fun onFailure(call: Call<ImagesResponse>, t: Throwable) {
                Log.e("ERROR!", t.toString())
            }

            override fun onResponse(
                call: Call<ImagesResponse>,
                response: Response<ImagesResponse>
            ) {
                val backdrops = response.body()?.backdrops
                Log.i("BACKDROPSNO", backdrops?.get(0)!!.filePath)
                if (backdrops!!.isNotEmpty()) {
                    viewPager2.adapter = ViewPagerAdapter(backdrops)
                    Log.i("BACKDROPS", backdrops[0].filePath)
                }

            }
        })
    }
}