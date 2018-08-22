package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.seating

import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Seating
import com.mobile.boriandmallory.boriandmalloryweddingandroid.networking.RestClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class SeatingPresenter : SeatingContract.Presenter {

    private lateinit var view: SeatingContract.View
    private var disposables = CompositeDisposable()
    private var seating: List<Seating>? = null

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
        seating?.let {
            view.setupSeating(it)
            return
        }

        view.showProgress(true)
        disposables += seatingService.getSeating()
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { view.showProgress(false) }
                .subscribe(this::onSeatingSuccess, this::onSeatingError)
    }

    private fun onSeatingSuccess(seating: List<Seating>) {
        this.seating = seating
        view.setupSeating(seating)
    }

    private fun onSeatingError(t: Throwable) {
        // TODO: handle error here
    }
}
