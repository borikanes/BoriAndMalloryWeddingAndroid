package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food

import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Food

/**
 * Creates food objects for display
 */
class FoodFactory {

    companion object {
        fun getFood() = listOf(
                Food(R.drawable.baked_salmon,
                        R.string.baked_salmon,
                        ""),
                Food(R.drawable.chin_chin,
                        R.string.chin_chin,
                        ""),
                Food(R.drawable.efo_elegusi,
                        R.string.efo_elegusi,
                        ""),
                Food(R.drawable.efo_riro,
                        R.string.efo_riro,
                        ""),
                Food(R.drawable.fried_rice,
                        R.string.fried_rice,
                        ""),
                Food(R.drawable.italian_seasoned,
                        R.string.italian_seasoned,
                        ""),
                Food(R.drawable.jollof_rice,
                        R.string.jollof_rice,
                        ""),
                Food(R.drawable.meat_pie,
                        R.string.meat_pie,
                        ""),
                Food(R.drawable.moin_moin,
                        R.string.moin_moin,
                        ""),
                Food(R.drawable.puff_puff,
                        R.string.puff_puff,
                        ""),
                Food(R.drawable.stewed_chicken,
                        R.string.stewed_chicken,
                        ""),
                Food(R.drawable.yam_porridge,
                        R.string.yam_porridge,
                        "")
        )


    }
}