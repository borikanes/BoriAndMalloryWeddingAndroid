package com.mobile.boriandmallory.boriandmalloryweddingandroid.models

import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

data class Food(val description: String? = null,
                val glutenFree: Boolean? = null,
                val image: String? = null,
                val title: String? = null,
                val vegetarian: Boolean? = null) : Parcelable {

    companion object CREATOR : Parcelable.Creator<Food> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this(
            description = parcel.readValue(String::class.java.classLoader) as? String?,
            glutenFree = parcel.readValue(Boolean::class.java.classLoader) as? Boolean?,
            image = parcel.readValue(String::class.java.classLoader) as? String?,
            title = parcel.readValue(String::class.java.classLoader) as? String?,
            vegetarian = parcel.readValue(Boolean::class.java.classLoader) as? Boolean?)

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeValue(description)
        parcel?.writeValue(glutenFree)
        parcel?.writeValue(image)
        parcel?.writeValue(title)
        parcel?.writeValue(vegetarian)
    }

    override fun describeContents(): Int = 0
}
