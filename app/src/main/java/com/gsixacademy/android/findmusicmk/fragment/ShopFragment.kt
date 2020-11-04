package com.gsixacademy.android.findmusicmk.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsixacademy.android.findmusicmk.R
import com.gsixacademy.android.findmusicmk.adapters.ShopAdapter
import com.gsixacademy.android.findmusicmk.data.ShopData
import com.gsixacademy.android.findmusicmk.data.ShopModel
import kotlinx.android.synthetic.main.botom_navigation_shop.*
import kotlinx.android.synthetic.main.recycler_shop.*
import kotlinx.android.synthetic.main.shop_fragment.*

class ShopFragment:Fragment() {

    lateinit var shopAdapter:ShopAdapter
    var shopModel: ShopModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shop_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var shops: HashSet<String> = HashSet()


        val array= arrayOfNulls<String>(shops.size)
        shopAdapter= ShopAdapter(requireActivity(),shops.toArray(array))
        recyclerView_shop.adapter=shopAdapter


        shop_iv.setOnClickListener{
            var bundle=Bundle()
            bundle.putString("shopClicked",recyclerView_shop.isSelected.toString())
            findNavController().navigate(R.id.action_shopFragment_to_singleShopFragment,bundle)

        }


    }



}