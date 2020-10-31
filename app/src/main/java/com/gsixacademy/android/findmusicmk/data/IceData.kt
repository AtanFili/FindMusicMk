package com.gsixacademy.android.findmusicmk.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class IceData(): Parcelable {

    var cd:Boolean=false
    var equipment:Boolean=false
    var instrument:Boolean=false

    constructor(parcel: Parcel) : this() {
        cd = parcel.readByte() != 0.toByte()
        equipment = parcel.readByte() != 0.toByte()
        instrument = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (cd) 1 else 0)
        parcel.writeByte(if (equipment) 1 else 0)
        parcel.writeByte(if (instrument) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IceData> {
        override fun createFromParcel(parcel: Parcel): IceData {
            return IceData(parcel)
        }

        override fun newArray(size: Int): Array<IceData?> {
            return arrayOfNulls(size)
        }
    }


}
