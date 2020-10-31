package com.gsixacademy.android.findmusicmk.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class WorkingHoursData() : Parcelable {

    var mon_fri:String?=null
    var sat:String?=null
    var sun:String?=null

    constructor(parcel: Parcel) : this() {
        mon_fri = parcel.readString()
        sat = parcel.readString()
        sun = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
       mon_fri?.let { parcel.writeString(it) }
        sat?.let { parcel.writeString(it) }
        sun?.let { parcel.writeString(it) }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WorkingHoursData> {
        override fun createFromParcel(parcel: Parcel): WorkingHoursData {
            return WorkingHoursData(parcel)
        }

        override fun newArray(size: Int): Array<WorkingHoursData?> {
            return arrayOfNulls(size)
        }
    }

}
