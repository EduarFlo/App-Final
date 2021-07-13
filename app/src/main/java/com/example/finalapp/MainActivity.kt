package com.example.finalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        buttonRFC.setOnClickListener {
            val intent:Intent = Intent(this, Rfc_generator::class.java)
            startActivity(intent)

        }

        buttonCURP.setOnClickListener {
            val curp: Intent = Intent(this, Curp::class.java)
            startActivity(curp)
        }

        buttonFriend.setOnClickListener {
            val friend: Intent = Intent(this,AmigoSecreto::class.java )
            startActivity(friend)
        }


    }
}