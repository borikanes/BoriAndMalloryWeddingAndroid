package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.food

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.firestore.FirebaseFirestore
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Food
import kotlinx.android.synthetic.main.fragment_food.*

/**
 * The fragment for displaying the fourth tab of information.  This will show information
 * about the different types of food offered at the wedding.
 */
class FoodFragment : Fragment(), FoodClickListener {

    companion object {

        /**
         * Creates a new instance of this fragment and sets the arguments
         *
         * @param args The arguments to set on the fragment
         * @return [FoodFragment]
         */
        fun newInstance(args: Bundle? = null): FoodFragment {
            val fragment = FoodFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showProgress(true)

        food_recycler_view.layoutManager = LinearLayoutManager(context)
        food_recycler_view.adapter = FoodRecyclerAdapter(listOf(), this)

        val db = FirebaseFirestore.getInstance()

        db.collection("food")
                .orderBy("title")
                .get()
                .addOnSuccessListener {
                    val food = it.documents.mapNotNull { doc -> doc.toObject(Food::class.java) }
                    val adapter = FoodRecyclerAdapter(food, this)
                    food_recycler_view.adapter = adapter
                    showProgress(false)
                }
                .addOnFailureListener {
                    // TODO: handle this error appropriately
                    showProgress(false)
                }
    }

    private fun showProgress(show: Boolean) {
        food_progress.visibility = if (show) View.VISIBLE else View.GONE
        food_recycler_view.visibility = if (!show) View.VISIBLE else View.GONE
    }

    override fun onItemClicked(food: Food, foodImageView: View) {
        val intent = Intent(context, FoodDetailActivity::class.java)
        intent.putExtra(FoodDetailActivity.EXTRA_FOOD_ITEM, food)
        intent.putExtra(FoodDetailActivity.EXTRA_FOOD_IMAGE_TRANSITION_NAME, ViewCompat.getTransitionName(foodImageView))

        val options = activity?.let {
            ActivityOptionsCompat.makeSceneTransitionAnimation(
                    it,
                    foodImageView,
                    ViewCompat.getTransitionName(foodImageView) ?: ""
            )
        }

        startActivity(intent, options?.toBundle())
    }
}
