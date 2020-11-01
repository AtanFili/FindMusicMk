package com.gsixacademy.android.findmusicmk.adapters

import com.gsixacademy.android.findmusicmk.data.ShopData

sealed class ShopDataClickEvent {

    data class ShopDataItemClicked(val shopdata:ShopData):ShopDataClickEvent()

}
