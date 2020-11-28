package com.example.companionapp.Classes

import android.os.Parcel
import android.os.Parcelable

data class Armor(
    var power:Int,
    var image:String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(power)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Armor> {
        override fun createFromParcel(parcel: Parcel): Armor {
            return Armor(parcel)
        }

        override fun newArray(size: Int): Array<Armor?> {
            return arrayOfNulls(size)
        }
    }
}