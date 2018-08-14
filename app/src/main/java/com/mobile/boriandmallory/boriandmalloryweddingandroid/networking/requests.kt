package com.mobile.boriandmallory.boriandmalloryweddingandroid.networking

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class DataRequests {

    public fun makeRequest(url: String, context: Context) {
        val queue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    print(response)
                },
                Response.ErrorListener { print("Network error") })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}