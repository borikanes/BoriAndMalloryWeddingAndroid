package com.mobile.boriandmallory.boriandmalloryweddingandroid

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

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