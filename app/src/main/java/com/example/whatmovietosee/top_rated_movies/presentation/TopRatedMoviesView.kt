package com.example.whatmovietosee.top_rated_movies.presentation

import com.example.whatmovietosee.domain.entity.TopRated.Movie
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse

interface TopRatedMoviesView {
    fun showTopRatedMovies(topRatedResponse: TopRatedResponse)
    fun navigateToMovieDetails(movie: Movie)
}