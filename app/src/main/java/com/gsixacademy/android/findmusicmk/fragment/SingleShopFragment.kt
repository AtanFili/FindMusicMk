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
import kotlinx.android.synthetic.main.botom_navigation_shop.*
import kotlinx.android.synthetic.main.single_shop.*

class SingleShopFragment:Fragment() {
    lateinit var shopData:ShopData
    val shopClicked = arguments?.getString("shopClicked")?:""
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
        title_shop.setText("PROBA")


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