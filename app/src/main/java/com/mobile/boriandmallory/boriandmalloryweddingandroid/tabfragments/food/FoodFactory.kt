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
                        0),
                Food(R.drawable.chin_chin,
                        R.string.chin_chin,
                        0),
                Food(R.drawable.efo_elegusi,
                        R.string.efo_elegusi,
                        0),
                Food(R.drawable.efo_riro,
                        R.string.efo_riro,
                        0),
                Food(R.drawable.fried_rice,
                        R.string.fried_rice,
                        0),
                Food(R.drawable.italian_seasoned,
                        R.string.italian_seasoned,
                        0),
                Food(R.drawable.jollof_rice,
                        R.string.jollof_rice,
                        0),
                Food(R.drawable.meat_pie,
                        R.string.meat_pie,
                        0),
                Food(R.drawable.moin_moin,
                        R.string.moin_moin,
                        0),
                Food(R.drawable.puff_puff,
                        R.string.puff_puff,
                        0),
                Food(R.drawable.stewed_chicken,
                        R.string.stewed_chicken,
                        0),
                Food(R.drawable.yam_porridge,
                        R.string.yam_porridge,
                        0)
        )


    }
}