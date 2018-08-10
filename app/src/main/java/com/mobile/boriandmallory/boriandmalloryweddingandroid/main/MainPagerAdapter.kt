package com.mobile.boriandmallory.boriandmalloryweddingandroid.main

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.HomeFragment
import com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.ScheduleFragment
import com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.SeatingFragment
import com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food.FoodFragment

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    enum class MainPagerPosition {
        HOME,
        SCHEDULE,
        SEATING,
        FOOD
    }

    override fun getItem(position: Int) =
            when (position) {
                MainPagerPosition.HOME.ordinal -> HomeFragment.newInstance()
                MainPagerPosition.SCHEDULE.ordinal -> ScheduleFragment.newInstance()
                MainPagerPosition.SEATING.ordinal -> SeatingFragment.newInstance()
                MainPagerPosition.FOOD.ordinal -> FoodFragment.newInstance()
                else -> null
            }

    override fun getCount() = 4
}