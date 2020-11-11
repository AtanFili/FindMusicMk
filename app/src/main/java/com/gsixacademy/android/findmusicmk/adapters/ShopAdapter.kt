package com.gsixacademy.android.findmusicmk.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.findmusicmk.R
import com.gsixacademy.android.findmusicmk.data.ShopData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.shop_fragment.view.*

class ShopAdapter (
    val shopDatas:ArrayList<ShopData>,
    val shopDatasClickEvent:(ShopDataClickEvent)->Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>
    () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.shop_fragment, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return shopDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(shopDatas[position], position)

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(shopData: ShopData, position: Int) {
            itemView.title_shop.text=shopData.name?.capitalize()
            Picasso.get().load(shopData.image).fit().into(itemView.shop_iv)
            itemView.shop_about_tv.text=shopData.about
            itemView.shopfragmentscrolview.setOnClickListener {
            shopDatasClickEvent.invoke(ShopDataClickEvent.ShopDataItemClicked(shopData))
            }

        }
    }
}