package com.gsixacademy.android.findmusicmk.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class LatlongData(): Parcelable {

    var lat:Double?=null
    var long:Double?=null

    constructor(parcel: Parcel) : this() {
        lat =parcel.readDouble()
        long = parcel.readDouble()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
       lat?.let { parcel.writeDouble(it) }
        long?.let { parcel.writeDouble(it) }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LatlongData> {
        override fun createFromParcel(parcel: Parcel): LatlongData {
            return LatlongData(parcel)
        }

        override fun newArray(size: Int): Array<LatlongData?> {
            return arrayOfNulls(size)
        }
    }

}
