package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food

import android.view.View
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Food

interface FoodClickListener {

    /**
     * Called when an item in the list of food is clicked
     *
     * @param food The food item that was clicked
     * @param foodImageView The image view that is going to be used in the transition
     */
    fun onItemClicked(food: Food, foodImageView: View)
}
