package com.example.whatmovietosee.top_rated_movies.domain

import com.example.whatmovietosee.data.ApiCallback
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse

interface TopRatedMoviesModel {
    fun getTopRatedMovies(apiCallback: ApiCallback<TopRatedResponse>, page: Int)
}