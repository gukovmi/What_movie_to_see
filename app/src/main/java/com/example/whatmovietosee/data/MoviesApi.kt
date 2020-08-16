package com.example.whatmovietosee.data

import ImagesResponse
import MovieDetails
import VideosResponse
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/top_rated")
    fun getTopRatedMovies (
        @Query("api_key") apiKey:String,
        @Query("language") language:String,
        @Query("page") page:Int
    ): Single<TopRatedResponse>

    @GET("movie/{movie_id}")
    fun getMovieById(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey:String,
        @Query("language") language:String
    ): Call<MovieDetails>

    @GET("movie/{movie_id}/videos")
    fun getVideosById(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey:String,
        @Query("language") language:String
    ): Call<VideosResponse>

    @GET("movie/{movie_id}/images")
    fun getImagesById(
        @Path("movie_id") movieId:Int,
        @Query("api_key") apiKey:String
    ): Call<ImagesResponse>
}