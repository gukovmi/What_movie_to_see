package com.example.whatmovietosee.top_rated_movies.domain

import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import io.reactivex.Single

interface TopRatedMoviesModel {
    fun getTopRatedMovies(page: Int): Single<TopRatedResponse>
}