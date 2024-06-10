package com.example.myweatherreportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMainScreen=findViewById<Button>(R.id.btn_main_screen)
        val btnExit=findViewById<Button>(R.id.btn_exit)

        btnMainScreen.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            finish()
        }








    }
}