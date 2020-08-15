package com.example.whatmovietosee.data

import ImagesResponse
import MovieDetails
import VideosResponse
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import retrofit2.Call

interface NetworkMoviesDataSource {
    fun getTopRatedMovies(callback: ApiCallback<TopRatedResponse>, page:Int)
    fun getMovieById(movieId:Int): Call<MovieDetails>
    fun getVideosById(movieId:Int): Call<VideosResponse>
    fun getImagesById(movieId:Int): Call<ImagesResponse>
}