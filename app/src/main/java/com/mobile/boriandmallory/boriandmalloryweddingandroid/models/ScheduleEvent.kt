package com.mobile.boriandmallory.boriandmalloryweddingandroid.models

import java.util.*

// TODO: is there a better way to define this data model than this with Firebase?
data class ScheduleEvent(val image1: String? = null,
                         val image2: String? = null,
                         val location: String? = null,
                         val title: String? = null,
                         val time: Date? = null)
