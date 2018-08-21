package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.seating

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Seating
import kotlinx.android.synthetic.main.item_seating.view.*

class SeatingAdapter(private val seating: List<Seating>) : RecyclerView.Adapter<SeatingAdapter.SeatingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_seating, parent, false)
        return SeatingViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeatingViewHolder, position: Int) {
        holder.bind(seating[position])
    }

    override fun getItemCount() = seating.size

    inner class SeatingViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(seat: Seating) {
            view.seating_name.text = seat.name
            view.seating_number.text = seat.table
        }
    }
}
