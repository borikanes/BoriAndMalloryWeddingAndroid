package com.mobile.boriandmallory.boriandmalloryweddingandroid.networking

import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {

    companion object {
        const val BASE_URL = "https://styf7r70gj.execute-api.us-east-1.amazonaws.com/prod"

        fun createSeatingService(): SeatingService = createRestClient().create(SeatingService::class.java)

        private fun createRestClient() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}
