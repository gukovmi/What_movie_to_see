package com.example.whatmovietosee.data

import ImagesResponse
import MovieDetails
import VideosResponse
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import retrofit2.Call

class MoviesRepositoryImpl(
    private val networkMoviesDataSource: NetworkMoviesDataSource
): MoviesRepository {

    override fun getTopRatedMovies(page: Int) {
        networkMoviesDataSource.getTopRatedMovies(page)
    }


    override fun getMovieById(movieId: Int): Call<MovieDetails> =
        networkMoviesDataSource.getMovieById(movieId)

    override fun getVideosById(movieId: Int): Call<VideosResponse> =
        networkMoviesDataSource.getVideosById(movieId)

    override fun getImagesById(movieId: Int): Call<ImagesResponse> =
        networkMoviesDataSource.getImagesById(movieId)
}