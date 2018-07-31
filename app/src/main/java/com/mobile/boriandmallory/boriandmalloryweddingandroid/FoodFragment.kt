package com.mobile.boriandmallory.boriandmalloryweddingandroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FoodFragment : Fragment() {

    companion object {
        fun newInstance(args: Bundle? = null): FoodFragment {
            val fragment = FoodFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food, container, false)
    }
}