package com.gsixacademy.android.findmusicmk.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.findmusicmk.MainActivity
import com.gsixacademy.android.findmusicmk.R
import com.gsixacademy.android.findmusicmk.data.ShopData
import com.gsixacademy.android.findmusicmk.data.ShopModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.botom_navigation_shop.*
import kotlinx.android.synthetic.main.single_shop.*

class SingleShopFragment:Fragment() {
    lateinit var shopData:ShopData

    var shopModel: ShopModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.single_shop,container,false)

    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shopModel = (activity as MainActivity).shopModel
        val shopName = arguments?.getString("shopName")?:""
        val shopImage = arguments?.getString("shopImage")?:""
        val shopAbout = arguments?.getString("shopAbout")?:""

        title_shop.text=shopName
        Picasso.get().load(shopImage).centerCrop().fit().into(shop_iv)
        shop_about_tv.text=shopAbout

        textview_map.setOnClickListener {
            findNavController().navigate(R.id.action_singleShopFragment_to_mapFragment)
        }
        textview_web.setOnClickListener {


            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("web"+shopData.web))
            startActivity(urlIntent)

        }
        textview_contact.setOnClickListener {

            val callIntent= Intent(Intent.ACTION_CALL, Uri.parse("tel:"+shopData.contact?.mob))
            startActivity(callIntent)
        }


    }
}
//Picasso.get().load(shopData.image).centerCrop().fit().into(itemView.shop_iv)