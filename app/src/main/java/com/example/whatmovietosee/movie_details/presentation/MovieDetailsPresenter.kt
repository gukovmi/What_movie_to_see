package com.example.whatmovietosee.movie_details.presentation

interface MovieDetailsPresenter {
    fun onViewAttached(movieId: Int)
    fun getMovieDetailsById(movieId: Int)
    fun getImagesById(movieId: Int)
    fun getVideosById(movieId: Int)
}