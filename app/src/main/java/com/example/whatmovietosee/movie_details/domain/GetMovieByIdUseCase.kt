package com.example.whatmovietosee.movie_details.domain

import MovieDetails
import com.example.whatmovietosee.data.MoviesRepository
import io.reactivex.Single

class GetMovieByIdUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(movieId: Int): Single<MovieDetails> =
        moviesRepository.getMovieById(movieId)
}