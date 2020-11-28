package com.example.companionapp.Classes

import android.os.Parcel
import android.os.Parcelable

data class Character(
    var power:Int,
    var characterclass: String?,
    var race:String?,
    var level:String?,
    var image:String?,
    var primaryweapon:List<Weapon>?,
    var specialweapon:List<Weapon>?,
    var heavyweapon:List<Weapon>?,
    var helmet:List<Armor>?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Weapon),
        parcel.createTypedArrayList(Weapon),
        parcel.createTypedArrayList(Weapon),
        parcel.createTypedArrayList(Armor)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(power)
        parcel.writeString(characterclass)
        parcel.writeString(race)
        parcel.writeString(level)
        parcel.writeString(image)
        parcel.writeTypedList(primaryweapon)
        parcel.writeTypedList(specialweapon)
        parcel.writeTypedList(heavyweapon)
        parcel.writeTypedList(helmet)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }

}






