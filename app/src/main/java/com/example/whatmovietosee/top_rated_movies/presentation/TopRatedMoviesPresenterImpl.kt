package com.example.whatmovietosee.top_rated_movies.presentation

import android.util.Log
import com.example.whatmovietosee.domain.entity.TopRated.Movie
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import com.example.whatmovietosee.top_rated_movies.di.TopRatedMoviesModelFactory
import com.example.whatmovietosee.top_rated_movies.domain.TopRatedMoviesModel
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers


class TopRatedMoviesPresenterImpl(
    private var view: TopRatedMoviesView
): TopRatedMoviesPresenter {
    private var model: TopRatedMoviesModel = TopRatedMoviesModelFactory().create()

    override fun onViewAttached() {
        getTopRatedMovies(1)
    }

    override fun onMovieItemClick(movie: Movie) {
        view.navigateToMovieDetails(movie)
    }


    override fun getTopRatedMovies(page: Int) {
        model.getTopRatedMovies(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showTopRatedMovies(it)
            }, {
                Log.e("Error!", it.toString())
            })

    }

    override fun nextPage(topRatedResponse: TopRatedResponse) {
        val currentPage =topRatedResponse.page
        val lastPage=topRatedResponse.totalPages
        if (currentPage<lastPage){
            getTopRatedMovies(currentPage+1)
        }
    }

    override fun previousPage(topRatedResponse: TopRatedResponse) {
        val currentPage =topRatedResponse.page
        val lastPage=topRatedResponse.totalPages
        if (currentPage>1){
            getTopRatedMovies(currentPage-1)
        }
    }


}