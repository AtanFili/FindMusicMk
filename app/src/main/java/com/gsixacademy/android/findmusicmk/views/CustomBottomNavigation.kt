package com.gsixacademy.android.findmusicmk.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.gsixacademy.android.findmusicmk.R
import kotlinx.android.synthetic.main.bottom_navigation.view.*

class CustomBottomNavigation:FrameLayout {
    internal  lateinit var mInflater:LayoutInflater

    constructor(context: Context):super(context){
        init(context)
    }
    constructor(context: Context,attr:AttributeSet?,style:Int):super(context,attr,style){
        init(context)

    }
    constructor(context: Context,attr: AttributeSet?):super(context,attr){
        init(context)
    }

    fun init(context: Context){
        mInflater=LayoutInflater.from(context)
        mInflater.inflate(R.layout.bottom_navigation,this,true)
    }
    fun setSelectedTab(tabToSelect:Int){

        textview_instrument.isSelected=tabToSelect == 1
        textview_cdshop.isSelected=tabToSelect==2
        textview_equipment.isSelected=tabToSelect==3

    }
}