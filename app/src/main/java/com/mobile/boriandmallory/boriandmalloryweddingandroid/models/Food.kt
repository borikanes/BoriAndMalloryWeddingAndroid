package com.mobile.boriandmallory.boriandmalloryweddingandroid.models

import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

data class Food(@DrawableRes val image: Int,
                @StringRes val name: Int,
                @StringRes val description: Int) : Parcelable {

    companion object CREATOR : Parcelable.Creator<Food> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }

    constructor(parcel: Parcel) : this(
            image = parcel.readInt(),
            name = parcel.readInt(),
            description = parcel.readInt())

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeInt(image)
        parcel?.writeInt(name)
        parcel?.writeInt(description)
    }

    override fun describeContents(): Int = 0
}