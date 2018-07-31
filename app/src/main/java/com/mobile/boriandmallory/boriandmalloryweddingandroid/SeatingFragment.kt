package com.mobile.boriandmallory.boriandmalloryweddingandroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * The fragment for showing the third tab of information.  This will show the seating chart for
 * the tables at the reception.
 */
class SeatingFragment : Fragment() {

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
}