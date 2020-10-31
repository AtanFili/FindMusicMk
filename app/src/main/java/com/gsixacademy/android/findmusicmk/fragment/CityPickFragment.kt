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
import com.gsixacademy.android.findmusicmk.MainActivity
import com.gsixacademy.android.findmusicmk.R
import com.gsixacademy.android.findmusicmk.data.ShopModel
import kotlinx.android.synthetic.main.botom_navigation_shop.*
import java.lang.StringBuilder

class CityPickFragment:Fragment() {

    var shopModel: ShopModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.city_activity_scroling,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val itemClicked = arguments?.getString("itemClicked")

        shopModel = (activity as MainActivity).shopModel

        var cities: HashSet<String> = HashSet()
        if(shopModel!=null && shopModel?.shop!=null)
        for(item in shopModel!!.shop!!){
            if(item !=null)
            cities.add(item.city.toString())
        }
Log.d("","")
        when(itemClicked){
            "instrument" ->{

            }
            "cd" ->{

            }



        }



    }
}
