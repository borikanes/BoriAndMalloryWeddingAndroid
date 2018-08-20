package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.seating

import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Seating

interface SeatingContract {

    interface View {

        /**
         * Sets up the seating UI with the data
         *
         * @param seating The seatign data to display
         */
        fun setupSeating(seating: List<Seating>)

        /**
         * Shows or hides the progress bar
         *
         * @param show True to show the progress bar, false to hide it
         */
        fun showProgress(show: Boolean)
    }

    interface Presenter {

        /**
         * Binds the view to this presenter
         *
         * @param view The view to bind
         */
        fun bind(view: View)

        /**
         * Retrieves the seating data from the API
         */
        fun getSeating()

        /**
         * Stops network requests when the view stops
         */
        fun onStop()
    }
}
