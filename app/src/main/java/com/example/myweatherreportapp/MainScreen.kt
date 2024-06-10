package com.example.myweatherreportapp

import android.content.Intent
import android.icu.text.Edits
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainScreen : AppCompatActivity() {
    private lateinit var tvDailyReport: TextView
    private lateinit var editMonday: EditText
    private lateinit var editTuesday: EditText
    private lateinit var editWednesday: EditText
    private lateinit var editThursday: EditText
    private lateinit var editFriday: EditText
    private lateinit var editSaturday: EditText
    private lateinit var editSunday: EditText
    private lateinit var btnDetailedView: Button
    private lateinit var btnClear: Button
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        tvDailyReport = findViewById(R.id.tv_daily_report)
        editMonday = findViewById(R.id.edit_monday)
        editTuesday = findViewById(R.id.edit_tuesday)
        editWednesday = findViewById(R.id.edit_wednesday)
        editThursday = findViewById(R.id.edit_thursday)
        editFriday = findViewById(R.id.edit_friday)
        editSaturday = findViewById(R.id.edit_saturday)
        editSunday = findViewById(R.id.edit_sunday)
        btnDetailedView = findViewById(R.id.btn_detailed_view_screen)
        btnClear = findViewById(R.id.btn_clear)
        btnCalculate = findViewById(R.id.btn_calculate)

        btnDetailedView.setOnClickListener {
            //Navigate to detailed view screen
            val intent = Intent(this, DetailedViewScreen::class.java)
            startActivity(intent)
        }
        btnClear.setOnClickListener {
            editMonday.setText("")
            editTuesday.setText("")
            editWednesday.setText("")
            editThursday.setText("")
            editFriday.setText("")
            editSaturday.setText("")
            editSunday.setText("")
        }
        btnCalculate.setOnClickListener {
            val averageTemperaturaForTheWeek = calculateAverageTemperatureForTheWeek()
            Toast.makeText(
                this,
                "Average Temperature For The Week: $averageTemperaturaForTheWeek",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun calculateAverageTemperatureForTheWeek(): Double {
        val days = arrayOf(
            editMonday,
            editTuesday,
            editWednesday,
            editThursday,
            editFriday,
            editSaturday,
            editSunday
        )

        var totalTemperatureForTheWeek = 0.0
        var validInputs = 0

        for (day in days) {
            if (day.text.isNotEmpty()) try {
                val temperature = day.text.toString().toDouble()
                totalTemperatureForTheWeek += temperature
                validInputs++
            } catch (e: NumberFormatException) {
                //You can handle the exception here,for example , by showing an error message
            }

        }
        return if (validInputs > 0) totalTemperatureForTheWeek / validInputs else 0.0
    }
}








