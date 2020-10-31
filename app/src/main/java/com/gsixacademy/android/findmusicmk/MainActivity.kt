package com.gsixacademy.android.findmusicmk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import com.gsixacademy.android.findmusicmk.data.ShopData
import com.gsixacademy.android.findmusicmk.data.ShopModel

class MainActivity : AppCompatActivity() {
    lateinit var database:DatabaseReference
    var shopModel:ShopModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database=FirebaseDatabase.getInstance().reference

      initaliseFireBaseDatabase()

    }
    private fun initaliseFireBaseDatabase(){
        val postListener= object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                //no implementation yet
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                shopModel=snapshot.getValue(ShopModel::class.java)
                Log.d("Proba","${shopModel?.shop?.size}")
            }

        }
        database.addValueEventListener(postListener)

    }

}
