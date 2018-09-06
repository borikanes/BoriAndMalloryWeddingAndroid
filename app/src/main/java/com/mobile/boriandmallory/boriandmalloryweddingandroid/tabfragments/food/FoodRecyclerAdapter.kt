package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.boriandmallory.boriandmalloryweddingandroid.GlideApp
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Food
import kotlinx.android.synthetic.main.item_food.view.*

class FoodRecyclerAdapter(private val foodList: List<Food>,
                          private val listener: FoodClickListener) : RecyclerView.Adapter<FoodRecyclerAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position], listener)
    }

    override fun getItemCount() = foodList.size

    inner class FoodViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(food: Food, listener: FoodClickListener) {
            ViewCompat.setTransitionName(view, food.title)

            GlideApp.with(view.context)
                    .load(food.image)
                    .dontAnimate()
                    .dontTransform()
                    .into(view.food_image)

            view.food_title.text = food.title

            view.setOnClickListener {
                listener.onItemClicked(food, view)
            }
        }
    }
}
