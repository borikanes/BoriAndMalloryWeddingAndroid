package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.seating

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.Seating
import kotlinx.android.synthetic.main.item_seating.view.*

class SeatingAdapter(private val seating: List<Seating>) :
        RecyclerView.Adapter<SeatingAdapter.SeatingViewHolder>(),
        Filterable {

    companion object {
        const val NULL = "null"
    }

    private var seatingFiltered = seating

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_seating, parent, false)
        return SeatingViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeatingViewHolder, position: Int) {
        holder.bind(seatingFiltered[position])
    }

    override fun getItemCount() = seatingFiltered.size

    override fun getFilter(): Filter = object : Filter() {
        override fun performFiltering(query: CharSequence?): FilterResults {
            val queryString: String = query.toString()
            seatingFiltered = if (queryString.isEmpty() || queryString == NULL) {
                seating
            } else {
                seating.filter {
                    it.name.toLowerCase().contains(queryString.toLowerCase()) || it.table.toLowerCase() == queryString.toLowerCase()
                }
            }
            val filterResults = FilterResults()
            filterResults.values = seatingFiltered
            return filterResults
        }

        override fun publishResults(query: CharSequence?, result: FilterResults?) {
            seatingFiltered = (result?.values as? List<*>)?.filterIsInstance<Seating>() ?: listOf()
            notifyDataSetChanged()
        }
    }

    inner class SeatingViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(seat: Seating) {
            view.seating_name.text = seat.name
            view.seating_number.text = seat.table
        }
    }
}
