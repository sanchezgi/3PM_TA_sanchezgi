package com.example.companionapp.Classes

import android.os.Parcel
import android.os.Parcelable

data class Weapon(
    var power:Int,
    var image:String?,
    var type:Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(power)
        parcel.writeString(image)
        parcel.writeInt(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Weapon> {
        override fun createFromParcel(parcel: Parcel): Weapon {
            return Weapon(parcel)
        }

        override fun newArray(size: Int): Array<Weapon?> {
            return arrayOfNulls(size)
        }
    }

}