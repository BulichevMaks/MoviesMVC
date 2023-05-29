package com.formgrav.mymovies.domain.api

import com.formgrav.mymovies.domain.models.Movie
import com.formgrav.mymovies.util.Resource

interface MoviesRepository {
    fun searchMovies(expression: String): Resource<List<Movie>>
}