package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.seating

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Seating
import com.mobile.boriandmallory.boriandmalloryweddingandroid.networking.RestClient
import kotlinx.android.synthetic.main.fragment_seating.*

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

        seating_recycler_view.layoutManager = LinearLayoutManager(context)
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun setupSeating(seating: List<Seating>) {
        seating_recycler_view.adapter = SeatingAdapter(seating)
    }

    override fun showProgress(show: Boolean) {
        seating_progress.visibility = if (show) View.VISIBLE else View.GONE
        seating_recycler_view.visibility = if (show) View.GONE else View.VISIBLE
    }
}
