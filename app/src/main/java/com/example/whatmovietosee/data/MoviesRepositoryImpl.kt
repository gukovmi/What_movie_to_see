package com.example.whatmovietosee.data

import ImagesResponse
import MovieDetails
import VideosResponse
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import io.reactivex.Single
import retrofit2.Call

class MoviesRepositoryImpl(
    private val networkMoviesDataSource: NetworkMoviesDataSource
): MoviesRepository {

    override fun getTopRatedMovies(page: Int): Single<TopRatedResponse> =
        networkMoviesDataSource.getTopRatedMovies(page)

    override fun getMovieById(movieId: Int): Single<MovieDetails> =
        networkMoviesDataSource.getMovieById(movieId)

    override fun getVideosById(movieId: Int): Single<VideosResponse> =
        networkMoviesDataSource.getVideosById(movieId)

    override fun getImagesById(movieId: Int): Single<ImagesResponse> =
        networkMoviesDataSource.getImagesById(movieId)
}