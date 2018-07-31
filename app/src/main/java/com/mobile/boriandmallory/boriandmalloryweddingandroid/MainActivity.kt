package com.mobile.boriandmallory.boriandmalloryweddingandroid

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

/**
 * The first activity the user will see in the app.  This houses the bottom navigation bar along
 * with a fragment view pager for switching between screens when the bottom bar items are tapped.
 */
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // listen for clicks on the bottom bar
        bottom_nav_bar.setOnNavigationItemSelectedListener(this)

        // set up view pager
        main_pager.adapter = MainPagerAdapter(supportFragmentManager)
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
}