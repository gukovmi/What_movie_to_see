package com.example.whatmovietosee.movie_details.presentation

import android.util.Log
import com.example.whatmovietosee.movie_details.di.MovieDetailsModelFactory
import com.example.whatmovietosee.movie_details.domain.MovieDetailsModel
import com.example.whatmovietosee.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailsPresenterImpl: MovieDetailsPresenter, BasePresenter<MovieDetailsView>() {

    private val model: MovieDetailsModel = MovieDetailsModelFactory().create()

    override fun onViewAttached(movieId: Int) {
        getMovieDetailsById(movieId)
        getImagesById(movieId)
        getVideosById(movieId)
    }

    override fun getMovieDetailsById(movieId: Int) {
        model.getMovieById(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showMovieDetails(it)
            }, {
                Log.e("Error!", it.toString())
            }).untilDestroy()
    }

    override fun getImagesById(movieId: Int) {
        model.getImagesById(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showImages(it)
            }, {
                Log.e("Error!", it.toString())
            }).untilDestroy()
    }

    override fun getVideosById(movieId: Int) {
        model.getVideosById(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showVideos(it)
            }, {
                Log.e("Error!", it.toString())
            }).untilDestroy()
    }
}