package com.mobile.boriandmallory.boriandmalloryweddingandroid.models

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

data class Food(@DrawableRes val image: Int,
                @StringRes val name: Int,
                val description: String)