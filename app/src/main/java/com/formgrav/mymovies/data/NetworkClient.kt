package com.formgrav.mymovies.data

import com.formgrav.mymovies.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response
}