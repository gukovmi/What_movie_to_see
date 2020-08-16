package com.example.whatmovietosee.movie_details.presentation

import ImagesResponse
import MovieDetails
import VideosResponse
import com.example.whatmovietosee.presentation.base.BaseView

interface MovieDetailsView: BaseView {
    fun showMovieDetails(movieDetails: MovieDetails)
    fun showImages(imagesResponse: ImagesResponse)
    fun showVideos(videosResponse: VideosResponse)
}