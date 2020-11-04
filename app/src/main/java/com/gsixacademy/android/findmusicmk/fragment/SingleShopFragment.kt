package com.gsixacademy.android.findmusicmk.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.findmusicmk.R
import kotlinx.android.synthetic.main.botom_navigation_shop.*

class SingleShopFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.single_shop,container,false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        textview_map.setOnClickListener {
            findNavController().navigate(R.id.action_cityPickFragment_to_mapFragment)
        }
        textview_web.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(urlIntent)

        }
        textview_contact.setOnClickListener {
            val callIntent= Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"0038977859244"))
            startActivity(callIntent)
        }

    }
}