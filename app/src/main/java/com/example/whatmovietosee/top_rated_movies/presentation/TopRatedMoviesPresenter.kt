package com.example.whatmovietosee.top_rated_movies.presentation

import com.example.whatmovietosee.domain.entity.TopRated.Movie
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse

interface TopRatedMoviesPresenter {
    fun onViewAttached()
    fun onMovieItemClick(movie: Movie)
    fun getTopRatedMovies(page: Int)
    fun nextPage(topRatedResponse:TopRatedResponse)
    fun previousPage(topRatedResponse:TopRatedResponse)
}