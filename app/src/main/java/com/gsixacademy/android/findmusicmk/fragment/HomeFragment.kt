package com.gsixacademy.android.findmusicmk.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.findmusicmk.R
import kotlinx.android.synthetic.main.bottom_navigation.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textview_instrument.setOnClickListener {
          var bundle = Bundle()
            bundle.putString("itemClicked","instrument")
            findNavController().navigate(R.id.action_homeFragment_to_cityPickFragment,bundle)
        }
        textview_cdshop.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("itemClicked","cd")
            findNavController().navigate(R.id.action_homeFragment_to_cityPickFragment,bundle)
        }
        textview_equipment.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("itemClicked","equipment")
            findNavController().navigate(R.id.action_homeFragment_to_cityPickFragment,bundle)
        }

    }
}