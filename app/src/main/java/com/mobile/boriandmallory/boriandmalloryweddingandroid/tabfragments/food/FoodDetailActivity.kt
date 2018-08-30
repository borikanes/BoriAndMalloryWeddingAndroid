package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
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
        food?.title?.let { food_detail_title.text = it }
        food?.description?.let { food_detail_description.text = it }

        food?.image?.let {
            Glide.with(this)
                    .load(it)
                    .into(food_detail_image)
        }
    }
}
