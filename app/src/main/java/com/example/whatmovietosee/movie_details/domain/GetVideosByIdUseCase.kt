package com.example.whatmovietosee.movie_details.domain

import VideosResponse
import com.example.whatmovietosee.data.MoviesRepository
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import io.reactivex.Single

class GetVideosByIdUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(movieId: Int): Single<VideosResponse> =
        moviesRepository.getVideosById(movieId)
}