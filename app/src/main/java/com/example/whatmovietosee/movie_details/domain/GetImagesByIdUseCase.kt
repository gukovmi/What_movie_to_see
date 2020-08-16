package com.example.whatmovietosee.movie_details.domain

import ImagesResponse
import com.example.whatmovietosee.data.MoviesRepository
import io.reactivex.Single

class GetImagesByIdUseCase (
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(movieId:Int): Single<ImagesResponse> =
        moviesRepository.getImagesById(movieId)
}
