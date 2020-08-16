package com.example.whatmovietosee.data

import ImagesResponse
import MovieDetails
import VideosResponse
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import io.reactivex.Single

interface MoviesRepository {
    fun getTopRatedMovies(page:Int): Single<TopRatedResponse>
    fun getMovieById(movieId:Int): Single<MovieDetails>
    fun getVideosById(movieId:Int): Single<VideosResponse>
    fun getImagesById(movieId:Int): Single<ImagesResponse>
}