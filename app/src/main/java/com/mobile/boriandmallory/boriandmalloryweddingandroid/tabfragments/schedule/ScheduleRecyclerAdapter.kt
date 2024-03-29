package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.schedule

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.ScheduleEvent
import kotlinx.android.synthetic.main.item_schedule.view.*
import java.text.SimpleDateFormat
import java.util.*

class ScheduleRecyclerAdapter(private val schedule: List<ScheduleEvent>) : RecyclerView.Adapter<ScheduleRecyclerAdapter.ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(schedule[position])
    }

    override fun getItemCount() = schedule.size

    inner class ScheduleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val formatter = SimpleDateFormat("h:mm a", Locale.US)

        fun bind(event: ScheduleEvent) {
            view.schedule_title.text = event.title
            view.schedule_time.text = formatter.format(event.time)

            Glide.with(view.context)
                    .load(event.image1)
                    .into(view.schedule_image1)
        }
    }
}
