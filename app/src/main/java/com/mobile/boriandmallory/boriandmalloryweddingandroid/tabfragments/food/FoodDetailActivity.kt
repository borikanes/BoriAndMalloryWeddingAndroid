package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food

import android.os.Build
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Food
import kotlinx.android.synthetic.main.activity_food_detail.*
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.mobile.boriandmallory.boriandmalloryweddingandroid.GlideApp


class FoodDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FOOD_ITEM = "extraFoodItem"
        const val EXTRA_FOOD_IMAGE_TRANSITION_NAME = "extraFoodImageTransitionName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        // delays the enter transition until this screen has completely loaded
        supportPostponeEnterTransition()

        val food: Food? = intent.extras.getParcelable(EXTRA_FOOD_ITEM) as? Food

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (food?.title != null) {
            supportActionBar?.title = food.title
        } else {
            supportActionBar?.title = getString(R.string.bottom_bar_food)
        }

        food?.description?.let { food_detail_description.text = it }

        food?.vegetarian?.let {
            food_detail_vegetarian_image.setImageResource(if (it) R.drawable.ic_check_green else R.drawable.ic_cancel_red)
        } ?: food_detail_vegetarian_image.setImageResource(R.drawable.ic_cancel_red)

        food?.glutenFree?.let {
            food_detail_gluten_free_image.setImageResource(if (it) R.drawable.ic_check_green else R.drawable.ic_cancel_red)
        } ?: food_detail_gluten_free_image.setImageResource(R.drawable.ic_cancel_red)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val imageTransitionName = intent.extras.getString(EXTRA_FOOD_IMAGE_TRANSITION_NAME)
            food_detail_image.transitionName = imageTransitionName
        }

        food?.image?.let {
            GlideApp.with(this)
                    .load(it)
                    .dontAnimate()
                    .dontTransform()
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            supportStartPostponedEnterTransition()
                            return false
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            supportStartPostponedEnterTransition()
                            return false
                        }
                    })
                    .into(food_detail_image)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
