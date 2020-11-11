package com.gsixacademy.android.findmusicmk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.google.firebase.database.*
import com.gsixacademy.android.findmusicmk.data.ShopData
import com.gsixacademy.android.findmusicmk.data.ShopModel

class MainActivity : AppCompatActivity() {
    lateinit var database:DatabaseReference
    var shopModel:ShopModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        //hide status bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)


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

            }

        }
        database.addValueEventListener(postListener)

    }

}
