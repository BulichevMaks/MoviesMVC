package com.formgrav.mymovies.util

import android.app.Activity
import android.content.Context
import com.formgrav.mymovies.data.MoviesRepositoryImpl
import com.formgrav.mymovies.data.network.RetrofitNetworkClient
import com.formgrav.mymovies.domain.api.MoviesInteractor
import com.formgrav.mymovies.domain.api.MoviesRepository
import com.formgrav.mymovies.domain.impl.MoviesInteractorImpl
import com.formgrav.mymovies.presentation.MoviesSearchController
import com.formgrav.mymovies.presentation.PosterController
import com.formgrav.mymovies.ui.movies.MoviesAdapter

object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }

    fun provideMoviesSearchController(activity: Activity, adapter: MoviesAdapter): MoviesSearchController {
        return MoviesSearchController(activity, adapter)
    }

    fun providePosterController(activity: Activity): PosterController {
        return PosterController(activity)
    }
}