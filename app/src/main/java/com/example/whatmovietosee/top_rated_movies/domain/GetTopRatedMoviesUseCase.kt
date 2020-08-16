package com.example.whatmovietosee.top_rated_movies.domain

import android.util.Log
import com.example.whatmovietosee.data.ApiCallback
import com.example.whatmovietosee.data.MoviesRepository
import com.example.whatmovietosee.data.MoviesRepositoryImpl
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import io.reactivex.Single

class GetTopRatedMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {
    operator fun invoke(page: Int): Single<TopRatedResponse> =
        moviesRepository.getTopRatedMovies(page)

}