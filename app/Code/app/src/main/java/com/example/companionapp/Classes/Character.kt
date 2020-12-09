package com.example.companionapp.Classes

import android.os.Parcel
import android.os.Parcelable

data class Character(
    var power:Int,
    var characterclass: String?,
    var race:String?,
    var level:String?,
    var image:String?,
    var primaryweapon:Array<Weapon>?,
    var specialweapon:Array<Weapon>?,
    var heavyweapon:Array<Weapon>?,
    var helmet:Array<Armor>?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArray(Weapon),
        parcel.createTypedArray(Weapon),
        parcel.createTypedArray(Weapon),
        parcel.createTypedArray(Armor)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(power)
        parcel.writeString(characterclass)
        parcel.writeString(race)
        parcel.writeString(level)
        parcel.writeString(image)
        parcel.writeTypedArray(primaryweapon, flags)
        parcel.writeTypedArray(specialweapon, flags)
        parcel.writeTypedArray(heavyweapon, flags)
        parcel.writeTypedArray(helmet, flags)
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






