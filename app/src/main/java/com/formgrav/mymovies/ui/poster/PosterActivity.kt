package com.formgrav.mymovies.ui.poster

import android.app.Activity
import android.os.Bundle
import com.formgrav.mymovies.util.Creator
import com.formgrav.mymovies.R

class PosterActivity : Activity() {

    private val posterController = Creator.providePosterController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poster)
        posterController.onCreate()
    }
}