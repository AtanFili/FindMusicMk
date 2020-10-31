package com.gsixacademy.android.findmusicmk.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class ContactData(): Parcelable {

    var mob:String?=null
    var phone:String?=null

    constructor(parcel: Parcel) : this() {
        mob = parcel.readString()
        phone = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
       mob?.let { parcel.writeString(it) }
        phone?.let { parcel.writeString(it) }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactData> {
        override fun createFromParcel(parcel: Parcel): ContactData {
            return ContactData(parcel)
        }

        override fun newArray(size: Int): Array<ContactData?> {
            return arrayOfNulls(size)
        }
    }

}
