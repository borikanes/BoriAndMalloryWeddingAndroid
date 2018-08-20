package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.seating

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Seating
import com.mobile.boriandmallory.boriandmalloryweddingandroid.networking.RestClient

/**
 * The fragment for showing the third tab of information.  This will show the seating chart for
 * the tables at the reception.
 */
class SeatingFragment : Fragment(), SeatingContract.View {

    private val presenter = SeatingPresenter()

    companion object {

        /**
         * Creates a new instance of this fragment and sets the arguments
         *
         * @param args The arguments to set on the fragment
         * @return [SeatingFragment]
         */
        fun newInstance(args: Bundle? = null): SeatingFragment {
            val fragment = SeatingFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_seating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.bind(this)
        presenter.getSeating()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun setupSeating(seating: List<Seating>) {
        // TODO: add data to recycler view
    }

    override fun showProgress(show: Boolean) {
        // TODO: show or hide progress view
    }
}
