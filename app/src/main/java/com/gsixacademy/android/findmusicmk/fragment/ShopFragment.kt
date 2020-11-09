package com.gsixacademy.android.findmusicmk.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsixacademy.android.findmusicmk.MainActivity
import com.gsixacademy.android.findmusicmk.R
import com.gsixacademy.android.findmusicmk.adapters.ShopAdapter
import com.gsixacademy.android.findmusicmk.adapters.ShopDataClickEvent
import com.gsixacademy.android.findmusicmk.data.ShopData
import com.gsixacademy.android.findmusicmk.data.ShopModel
import kotlinx.android.synthetic.main.botom_navigation_shop.*
import kotlinx.android.synthetic.main.recycler_shop.*

class ShopFragment:Fragment() {

    lateinit var shopAdapter:ShopAdapter
    var shopModel: ShopModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_shop,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val shops = (activity as MainActivity).shopModel?.shop?: ArrayList()
        val filteredShops: ArrayList<ShopData> = ArrayList()
        val cityClicked = arguments?.getString("cityClicked")?:""
        val selectedItem = arguments?.getString("selectedItem")?:""
        for(item in shops){
            when(selectedItem){
                "instrument" ->{
                    if(item!=null && item.city== cityClicked && item.ice?.instrument == true) {
                        filteredShops.add(item)
                    }
                }
                "cd" ->{
                    if(item!=null && item.city== cityClicked && item.ice?.cd == true) {
                        filteredShops.add(item)
                    }
                }
                "equipment" ->{
                    if(item!=null && item.city== cityClicked && item.ice?.equipment == true) {
                        filteredShops.add(item)
                    }
                }
            }

        }

        shopAdapter= ShopAdapter(filteredShops){
            if(it is ShopDataClickEvent.ShopDataItemClicked) {
                Log.d("shopClicked", "" +it.shopdata.name)
                var bundle = Bundle()
                bundle.putString("shopName", it.shopdata.name)
                bundle.putString("shopImage", it.shopdata.image)
                bundle.putString("shopAbout", it.shopdata.about)


                findNavController().navigate(R.id.action_shopFragment_to_singleShopFragment, bundle)
            }
        }
        recyclerView_shop.adapter=shopAdapter


//        shop_iv.setOnClickListener{
//            var bundle=Bundle()
//            bundle.putString("shopClicked",recyclerView_shop.isSelected.toString())
//            findNavController().navigate(R.id.action_shopFragment_to_singleShopFragment,bundle)
//
//        }


    }



}