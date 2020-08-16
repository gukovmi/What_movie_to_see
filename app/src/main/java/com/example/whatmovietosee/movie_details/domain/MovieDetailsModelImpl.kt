package com.example.whatmovietosee.movie_details.domain

import ImagesResponse
import MovieDetails
import VideosResponse
import io.reactivex.Single

class MovieDetailsModelImpl(
    private val getMovieByIdUseCase: GetMovieByIdUseCase,
    private val getVideosByIdUseCase: GetVideosByIdUseCase,
    private val getImagesByIdUseCase: GetImagesByIdUseCase
): MovieDetailsModel
{
    override fun getMovieById(movieId: Int): Single<MovieDetails> =
        getMovieByIdUseCase(movieId)

    override fun getVideosById(movieId: Int): Single<VideosResponse> =
        getVideosByIdUseCase(movieId)

    override fun getImagesById(movieId: Int): Single<ImagesResponse> =
        getImagesByIdUseCase(movieId)
}