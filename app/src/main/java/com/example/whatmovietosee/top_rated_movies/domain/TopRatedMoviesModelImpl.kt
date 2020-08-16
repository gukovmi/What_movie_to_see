package com.example.whatmovietosee.top_rated_movies.domain

import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import io.reactivex.Single

class TopRatedMoviesModelImpl(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
): TopRatedMoviesModel {

    override fun getTopRatedMovies(page: Int): Single<TopRatedResponse> =
        getTopRatedMoviesUseCase(page)
}