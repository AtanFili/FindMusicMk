package com.gsixacademy.android.findmusicmk.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.findmusicmk.MainActivity
import com.gsixacademy.android.findmusicmk.R
import com.gsixacademy.android.findmusicmk.adapters.CityAdapter
import com.gsixacademy.android.findmusicmk.data.ShopModel
import com.gsixacademy.android.findmusicmk.data.SpinerModel
import kotlinx.android.synthetic.main.city_activity_scroling.*

class CityPickFragment:Fragment() {
    lateinit var cityList:ArrayList<SpinerModel>
    lateinit var cityAdapter: CityAdapter
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
            if(item!=null)
            when(itemClicked){
                "instrument" -> {
                    var instrumentExist = item.ice?.instrument?:false
                    if( instrumentExist )
                        cities.add(item.city.toString())
                }
                "cd" -> {
                    var cdExist = item.ice?.cd?:false
                    if( cdExist )
                        cities.add(item.city.toString())
                }
                "equipment" -> {
                    var equipmentExist = item.ice?.equipment?:false
                    if(equipmentExist )
                        cities.add(item.city.toString())
                }
            }

        }

        val array = arrayOfNulls<String>(cities.size)
        cityAdapter= CityAdapter(requireActivity(),cities.toArray(array))
        city_spinner.adapter=cityAdapter

        button_next.setOnClickListener{
            Log.d("selectedItem",""+city_spinner.selectedItem.toString())
            var bundle = Bundle()
            bundle.putString("cityClicked",city_spinner.selectedItem.toString())
            findNavController().navigate(R.id.action_cityPickFragment_to_shopFragment,bundle)
        }
    }
}
