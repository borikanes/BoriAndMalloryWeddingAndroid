package com.mobile.boriandmallory.boriandmalloryweddingandroid.networking

import android.content.Context
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.SeatingResponseFromAPI
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class DataRequests {
    private var seatingDataAPI: SeatingDataAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://styf7r70gj.execute-api.us-east-1.amazonaws.com/prod")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        seatingDataAPI = retrofit.create(SeatingDataAPI::class.java)
    }
}

interface  SeatingDataAPI {
    @GET("/seating")
    fun getData(): Call<SeatingResponseFromAPI>
}