package com.example.jetpack_tuto.new_navigation

import android.os.Parcel
import android.os.Parcelable

class UserParcelable(
    val nom: String,
    val prenom: String,
    val age: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(prenom)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserParcelable> {
        override fun createFromParcel(parcel: Parcel): UserParcelable {
            return UserParcelable(parcel)
        }

        override fun newArray(size: Int): Array<UserParcelable?> {
            return arrayOfNulls(size)
        }
    }
}