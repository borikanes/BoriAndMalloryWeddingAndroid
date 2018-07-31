package com.mobile.boriandmallory.boriandmalloryweddingandroid

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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