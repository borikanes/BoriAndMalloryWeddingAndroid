package com.mobile.boriandmallory.boriandmalloryweddingandroid.networking

import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Seating
import io.reactivex.Single
import retrofit2.http.GET

interface SeatingService {

    @GET("/seating")
    fun getSeating(): Single<List<Seating>>
}
