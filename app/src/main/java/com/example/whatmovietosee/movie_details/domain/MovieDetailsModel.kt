package com.example.whatmovietosee.movie_details.domain

import ImagesResponse
import MovieDetails
import VideosResponse
import io.reactivex.Single

interface MovieDetailsModel {
    fun getMovieById(movieId:Int): Single<MovieDetails>
    fun getVideosById(movieId:Int): Single<VideosResponse>
    fun getImagesById(movieId:Int): Single<ImagesResponse>
}