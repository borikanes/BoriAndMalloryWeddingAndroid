package com.mobile.boriandmallory.boriandmalloryweddingandroid.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * The first activity the user will see in the app.  This houses the bottom navigation bar along
 * with a fragment view pager for switching between screens when the bottom bar items are tapped.
 */
class MainActivity :
        AppCompatActivity(),
        BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.bottom_bar_home)

        // listen for clicks on the bottom bar
        bottom_nav_bar.setOnNavigationItemSelectedListener(this)

        // set up view pager
        main_pager.adapter = MainPagerAdapter(supportFragmentManager)
        main_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                setBottomBarItemSelected(position)
                updateToolbarTitle(position)
            }
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> main_pager.setCurrentItem(MainPagerAdapter.MainPagerPosition.HOME.ordinal, true)
            R.id.schedule -> main_pager.setCurrentItem(MainPagerAdapter.MainPagerPosition.SCHEDULE.ordinal, true)
            R.id.seating -> main_pager.setCurrentItem(MainPagerAdapter.MainPagerPosition.SEATING.ordinal, true)
            R.id.food -> main_pager.setCurrentItem(MainPagerAdapter.MainPagerPosition.FOOD.ordinal, true)
        }
        return true
    }

    private fun setBottomBarItemSelected(position: Int) {
        when (position) {
            MainPagerAdapter.MainPagerPosition.HOME.ordinal -> bottom_nav_bar.selectedItemId = R.id.home
            MainPagerAdapter.MainPagerPosition.SCHEDULE.ordinal -> bottom_nav_bar.selectedItemId = R.id.schedule
            MainPagerAdapter.MainPagerPosition.SEATING.ordinal -> bottom_nav_bar.selectedItemId = R.id.seating
            MainPagerAdapter.MainPagerPosition.FOOD.ordinal -> bottom_nav_bar.selectedItemId = R.id.food
        }
    }

    private fun updateToolbarTitle(position: Int) {
        supportActionBar?.title = when (position) {
            MainPagerAdapter.MainPagerPosition.SCHEDULE.ordinal -> getString(R.string.bottom_bar_schedule)
            MainPagerAdapter.MainPagerPosition.SEATING.ordinal -> getString(R.string.bottom_bar_seating)
            MainPagerAdapter.MainPagerPosition.FOOD.ordinal -> getString(R.string.bottom_bar_food)
            else -> getString(R.string.bottom_bar_home)
        }
    }
}
