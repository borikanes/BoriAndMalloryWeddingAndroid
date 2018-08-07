package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import kotlinx.android.synthetic.main.fragment_food.*

/**
 * The fragment for displaying the fourth tab of information.  This will show information
 * about the different types of food offered at the wedding.
 */
class FoodFragment : Fragment() {

    companion object {

        /**
         * Creates a new instance of this fragment and sets the arguments
         *
         * @param args The arguments to set on the fragment
         * @return [FoodFragment]
         */
        fun newInstance(args: Bundle? = null): FoodFragment {
            val fragment = FoodFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        food_recycler_view.layoutManager = LinearLayoutManager(context)
        food_recycler_view.adapter = FoodRecyclerAdapter(FoodFactory.getFood())
    }
}