package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

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

    private fun getTimeLeftToWedding(): String {
        val currentDate = Date()
        val weddingDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val weddingDate: Date = weddingDateFormat.parse("2018-09-22 11:00:00")
        val timeDifference = TimeUnit.HOURS.convert((currentDate.time - weddingDate.time), TimeUnit.MILLISECONDS)

        return when {
            timeDifference.toInt() > 0 -> getString(R.string.been_there)
            Math.abs(timeDifference.toInt()) in 0..11 -> getString(R.string.happens_today) // within 11 hours
            Math.abs(timeDifference.toInt()) in 12..24 -> getString(R.string.less_than_day) // within 24 hours
            else -> {
                val numberOfDays = Math.abs(timeDifference).toInt()
                when (numberOfDays) {
                    in 25..35 -> getString(R.string.one_day) // A day before, because actual time is 11hours past the top hour of midnight.
                    else -> getString(R.string.days_left, (Math.ceil(numberOfDays/24.0)).toInt().toString())
                }
            }
        }
    }

    private fun buttonBg() = GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        cornerRadius = 10f
        setStroke(2, Color.parseColor("#000000"))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setCountdown()
    }

    private fun setCountdown() {
        countdown.text = getString(R.string.home_countdown, getTimeLeftToWedding())
    }

    private fun setupView() {
        countdown.background = buttonBg()
        dateTextview.background = buttonBg()
        locationTextview.background = buttonBg()
    }
}