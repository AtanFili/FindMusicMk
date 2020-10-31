package com.gsixacademy.android.findmusicmk.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class ShopData (): Parcelable {
    var city:String?=null
    var contact:ContactData?=null
    var ice:IceData?=null
    var id:String?=null
    var latLong:LatlongData?=null
    var name:String?=null
    var web:String?=null
    var working_hours:WorkingHoursData?=null

    constructor(parcel: Parcel) : this() {
        city = parcel.readString()
        contact = parcel.readParcelable(ContactData::class.java.classLoader)
        ice = parcel.readParcelable(IceData::class.java.classLoader)
        id = parcel.readString()
        latLong = parcel.readParcelable(LatlongData::class.java.classLoader)
        name = parcel.readString()
        web = parcel.readString()
        working_hours = parcel.readParcelable(WorkingHoursData::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(city)
        parcel.writeParcelable(contact, flags)
        parcel.writeParcelable(ice, flags)
        parcel.writeString(id)
        parcel.writeParcelable(latLong, flags)
        parcel.writeString(name)
        parcel.writeString(web)
        parcel.writeParcelable(working_hours, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ShopData> {
        override fun createFromParcel(parcel: Parcel): ShopData {
            return ShopData(parcel)
        }

        override fun newArray(size: Int): Array<ShopData?> {
            return arrayOfNulls(size)



        }
    }


}
