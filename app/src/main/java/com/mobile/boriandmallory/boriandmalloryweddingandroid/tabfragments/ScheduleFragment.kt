package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R

/**
 * The fragment for displaying the second tab of information.  This will show
 * the schedule of events for the wedding day.
 */
class ScheduleFragment : Fragment() {

    companion object {

        /**
         * Creates a new instance of this fragment and sets the arguments
         *
         * @param args The arguments to set on the fragment
         * @return [ScheduleFragment]
         */
        fun newInstance(args: Bundle? = null): ScheduleFragment {
            val fragment = ScheduleFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }
}