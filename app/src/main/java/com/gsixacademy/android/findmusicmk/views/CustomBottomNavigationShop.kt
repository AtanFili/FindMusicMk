package com.gsixacademy.android.findmusicmk.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.gsixacademy.android.findmusicmk.R
import kotlinx.android.synthetic.main.botom_navigation_shop.view.*

class CustomBottomNavigationShop :FrameLayout{
    internal lateinit var mInflater: LayoutInflater

    constructor(context: Context) : super(context) {
        init(context)
    }
    constructor(context: Context, attr: AttributeSet?, style: Int) : super(context, attr, style) {
        init(context)
    }

    constructor(context: Context, attr: AttributeSet?) : super(context, attr) {
        init(context)
    }
    fun init(context: Context) {
        mInflater = LayoutInflater.from(context)
        mInflater.inflate(R.layout.botom_navigation_shop, this, true)

    }

    fun setSelectedTab(tabToSelect:Int){

        textview_map.isSelected=tabToSelect==1
        textview_web.isSelected=tabToSelect==2
        textview_contact.isSelected=tabToSelect==3


    }
    



}