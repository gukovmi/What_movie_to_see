package com.example.whatmovietosee.data

import ImagesResponse
import MovieDetails
import VideosResponse
import android.util.Log
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkMoviesDataSourceImpl(private val api: MoviesApi): NetworkMoviesDataSource  {

    override fun getTopRatedMovies(page: Int): Single<TopRatedResponse> =
        api.getTopRatedMovies(Constants.API_KEY, "ru", page)

    override fun getMovieById(movieId: Int): Single<MovieDetails> =
        api.getMovieById(movieId, Constants.API_KEY, "ru")

    override fun getVideosById(movieId: Int): Single<VideosResponse> =
        api.getVideosById(movieId, Constants.API_KEY, "ru")

    override fun getImagesById(movieId: Int): Single<ImagesResponse> =
        api.getImagesById(movieId, Constants.API_KEY)
}