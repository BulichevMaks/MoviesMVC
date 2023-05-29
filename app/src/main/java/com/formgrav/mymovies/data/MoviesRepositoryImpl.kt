package com.formgrav.mymovies.data

import android.util.Log
import com.formgrav.mymovies.data.dto.MoviesSearchRequest
import com.formgrav.mymovies.data.dto.MoviesSearchResponse
import com.formgrav.mymovies.domain.api.MoviesRepository
import com.formgrav.mymovies.domain.models.Movie
import com.formgrav.mymovies.util.Resource

class MoviesRepositoryImpl(private val networkClient: NetworkClient) : MoviesRepository {

    override fun searchMovies(expression: String): Resource<List<Movie>> {
        val response = networkClient.doRequest(MoviesSearchRequest(expression))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }
            200 -> {
                if ((response as MoviesSearchResponse).results.isNotEmpty()) {
                    return Resource.Success((response).results.map {
                        Movie(it.id, it.resultType, it.image, it.title, it.description)
                    })
                } else {
                    return Resource.Error("Ни чего не найдено")
                }
            }
            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }
}