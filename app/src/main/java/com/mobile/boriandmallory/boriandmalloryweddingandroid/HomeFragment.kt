package com.mobile.boriandmallory.boriandmalloryweddingandroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * The fragment for displaying the first tab of information.  Contains information
 * about wedding location and countdown.
 */
class HomeFragment : Fragment() {

    companion object {

        /**
         * Creates a new instance of this fragment and sets the arguments
         *
         * @param args The arguments to set on the fragment
         * @return [HomeFragment]
         */
        fun newInstance(args: Bundle? = null): HomeFragment {
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}