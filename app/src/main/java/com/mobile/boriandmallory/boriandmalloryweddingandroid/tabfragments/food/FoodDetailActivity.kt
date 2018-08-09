package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Food
import kotlinx.android.synthetic.main.activity_food_detail.*

// TODO: add back button to toolbar
// TODO: add title of food to toolbar and remove from bottom
// TODO: add animation of food image from list to detail

class FoodDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FOOD_ITEM = "extraFoodItem"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val food: Food? = intent.extras.getParcelable(EXTRA_FOOD_ITEM) as? Food
        food?.name?.let { food_detail_title.text = getString(it) }
        food?.image?.let { food_detail_image.setImageDrawable(ContextCompat.getDrawable(this, it)) }

    }
}