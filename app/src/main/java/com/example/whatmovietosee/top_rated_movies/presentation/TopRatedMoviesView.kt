package com.example.whatmovietosee.top_rated_movies.presentation

import com.example.whatmovietosee.domain.entity.TopRated.Movie
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import com.example.whatmovietosee.presentation.base.BaseView

interface TopRatedMoviesView: BaseView {
    fun showTopRatedMovies(topRatedResponse: TopRatedResponse)
    fun navigateToMovieDetails(movie: Movie)
}