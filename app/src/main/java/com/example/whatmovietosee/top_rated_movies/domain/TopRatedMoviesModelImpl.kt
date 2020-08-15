package com.example.whatmovietosee.top_rated_movies.domain

import com.example.whatmovietosee.data.ApiCallback
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse

class TopRatedMoviesModelImpl(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
): TopRatedMoviesModel {

    override fun getTopRatedMovies(apiCallback: ApiCallback<TopRatedResponse>, page: Int) {
        getTopRatedMoviesUseCase(apiCallback, page)
    }


}