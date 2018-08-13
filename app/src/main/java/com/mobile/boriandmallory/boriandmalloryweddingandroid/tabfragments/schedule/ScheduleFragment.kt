package com.mobile.boriandmallory.boriandmalloryweddingandroid.tabfragments.schedule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.firebase.firestore.FirebaseFirestore
import com.mobile.boriandmallory.boriandmalloryweddingandroid.R
import com.mobile.boriandmallory.boriandmalloryweddingandroid.models.ScheduleEvent
import kotlinx.android.synthetic.main.fragment_schedule.*

/**`
 * The fragment for displaying the second tab of information.  This will show
 * the schedule of events for the wedding day.
 */
class ScheduleFragment : Fragment() {

    companion object {

        /**
         * Creates a new instance of this fragment and sets the arguments
         *
         * @param args The arguments to set on the fragment
         * @return [ScheduleFragment]
         */
        fun newInstance(args: Bundle? = null): ScheduleFragment {
            val fragment = ScheduleFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    // TODO: verify firebase is caching appropriately
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val db = FirebaseFirestore.getInstance()

        db.collection("schedule")
                .get()
                .addOnSuccessListener {
                    val schedule = it.documents.mapNotNull { doc -> doc.toObject(ScheduleEvent::class.java) }
                    val adapter = ScheduleRecyclerAdapter(schedule)
                    schedule_recycler_view.layoutManager = LinearLayoutManager(context)
                    schedule_recycler_view.adapter = adapter
                }
                .addOnFailureListener {
                    // TODO: handle this error appropriately
                    Log.e("FIREBASE_ERROR", "WE HAVE AN ERROR")
                }
    }
}
