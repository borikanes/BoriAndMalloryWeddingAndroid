package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.seating

import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Seating
import com.mobile.boriandmallory.boriandmalloryweddingandroid.networking.RestClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class SeatingPresenter : SeatingContract.Presenter {

    private lateinit var view: SeatingContract.View
    private var disposables = CompositeDisposable()

    private val seatingService by lazy {
        RestClient.createSeatingService()
    }

    override fun bind(view: SeatingContract.View) {
        this.view = view
    }

    override fun onStop() {
        disposables.dispose()
    }

    override fun getSeating() {
        // TODO: handle loading

        disposables += seatingService.getSeating()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSeatingSuccess, this::onSeatingError)
    }

    private fun onSeatingSuccess(seating: List<Seating>) {
        // TODO: update recycler view with data
        // TODO: handle loading
    }

    private fun onSeatingError(t: Throwable) {
        // TODO: handle error here
    }
}
