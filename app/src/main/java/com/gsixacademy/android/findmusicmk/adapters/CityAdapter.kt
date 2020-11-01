package com.gsixacademy.android.findmusicmk.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.gsixacademy.android.findmusicmk.R
import com.gsixacademy.android.findmusicmk.data.SpinerModel
import com.gsixacademy.android.findmusicmk.fragment.CityPickFragment

class CityAdapter(
    val context: Activity,
    val data: () -> Unit
):BaseAdapter(){

    private val inflater:LayoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val vh:ItemHolder

        if (convertView==null){

            view=inflater.inflate(R.layout.customdropdown_layout,parent,false)
            vh=ItemHolder(view)
            view?.tag=vh


            }else{

            view=convertView
            vh=view.tag as ItemHolder
        }
        vh.cityname.text=data.get(position).city
        return  view
    }
    fun addItems(city:ArrayList<SpinerModel>){
        data.addAll(city)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    private class ItemHolder(row: View?){
        val cityname:TextView


        init {
            cityname=row?.findViewById(R.id.citynameTextView)as TextView
        }
    }
}