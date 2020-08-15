package com.example.whatmovietosee.data

import ImagesResponse
import MovieDetails
import VideosResponse
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import retrofit2.Call

interface MoviesRepository {
    fun getTopRatedMovies(apiCallback :ApiCallback<TopRatedResponse>, page:Int)//: TopRatedResponse?
    fun getMovieById(movieId:Int): Call<MovieDetails>
    fun getVideosById(movieId:Int): Call<VideosResponse>
    fun getImagesById(movieId:Int): Call<ImagesResponse>
}