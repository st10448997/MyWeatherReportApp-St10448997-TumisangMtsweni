package com.example.myweatherreportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailedViewScreen : AppCompatActivity() {
    private lateinit var tvDates: TextView
    private lateinit var tvMaxTemp:TextView
    private lateinit var tvMinTemp:TextView
    private lateinit var tvWeatherCondition:TextView
    private lateinit var btnBack:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_screen)

        tvDates=findViewById(R.id.tv_dates)
        tvMaxTemp=findViewById(R.id.tv_max_temp)
        tvMinTemp=findViewById(R.id.tv_min_temp)
        tvWeatherCondition=findViewById(R.id.tv_weather_condition)
        btnBack=findViewById(R.id.btn_back)

        val intent=intent
        val date = intent.getStringExtra("date")
        val maxTemp = intent.getDoubleExtra("max_temp",0.0)
        val minTemp =intent.getDoubleExtra("min_temp",0.0)
        val weatherCondition= intent.getStringExtra("weather_condition")

        tvDates.text = date
        tvMaxTemp.text = "MAX Temp:${maxTemp}C"
        tvMinTemp.text ="${minTemp}C"
        tvWeatherCondition.text="Weather Confition:$weatherCondition"

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            onBackPressed()
        }








    }
}