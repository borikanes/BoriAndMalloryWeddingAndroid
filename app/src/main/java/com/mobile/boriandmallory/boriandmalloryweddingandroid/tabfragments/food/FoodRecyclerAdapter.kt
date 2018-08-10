package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Food
import com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food.FoodDetailActivity.Companion.EXTRA_FOOD_ITEM
import kotlinx.android.synthetic.main.item_food.view.*

class FoodRecyclerAdapter(private val foodList: List<Food>) : RecyclerView.Adapter<FoodRecyclerAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount() = foodList.size

    inner class FoodViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(food: Food) {
            view.food_image.setImageDrawable(ContextCompat.getDrawable(view.context, food.image))
            view.food_title.text = view.context.getString(food.name)

            view.setOnClickListener {
                val intent = Intent(view.context, FoodDetailActivity::class.java)
                intent.putExtra(EXTRA_FOOD_ITEM, food)
                view.context.startActivity(intent)
            }
        }
    }
}