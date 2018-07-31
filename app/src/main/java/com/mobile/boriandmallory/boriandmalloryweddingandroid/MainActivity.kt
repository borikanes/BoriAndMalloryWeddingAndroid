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

        // TODO: set up ViewPager
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // TODO: switch fragments when selected
        when (item.itemId) {
            R.id.home -> {}
            R.id.schedule -> {}
            R.id.seating -> {}
            R.id.food -> {}
        }
        return true
    }
}