Weather-Report-App
Explainig the code It is a Kotlin Android app that consists of three activities: SplashActivity,MainActivity,and DetailedViewActivity

Breakdown of each activity SPLASHACTIVITY Sets the context view to activity_splash which is the mainactivity given from kotlin finds the two buttons by their ids Enter VIEW Dedtailed Screen when the button is clicked If user doesn't want to continues the is a button exit for the user to exit the application

MainActivity sets the content view to activity_main finds the seven EditText fields and two butttons by their ids sets an onclicklistener for each button

viewDetailedScreen botton starthe DetailedView Activity Clear Data button cleasrs the in all seven EditText

Defines a calculateAverageTemperatureForTheWeek() calculate the total temperature by summin up the value in the seven EditText Retur the average Temperature by time by dividing the total by 7

The purpose of creating his app Reliabilliy is to help user to know what to expuce for day to day weather coditiond

package com.example.myweatherreportapp

import android.content.Intent import androidx.appcompat.app.AppCompatActivity import android.os.Bundle import android.widget.Button

class MainActivity : AppCompatActivity() { override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) setContentView(R.layout.activity_main)

    val btnMainScreen=findViewById<Button>(R.id.btn_main_screen)
    val btnExit=findViewById<Button>(R.id.btn_exit)

    btnMainScreen.setOnClickListener {
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
    btnExit.setOnClickListener {
        finish()
    }
package com.example.myweatherreportapp

import android.content.Intent import android.icu.text.Edits import androidx.appcompat.app.AppCompatActivity import android.os.Bundle import android.widget.Button import android.widget.EditText import android.widget.TextView import android.widget.Toast

class MainScreen : AppCompatActivity() { private lateinit var tvDailyReport:TextView private lateinit var editMonday:EditText private lateinit var editTuesday:EditText private lateinit var editWednesday:EditText private lateinit var editThursday:EditText private lateinit var editFriday:EditText private lateinit var editSaturday:EditText private lateinit var editSunday:EditText private lateinit var btnDetailedView:Button private lateinit var btnClear:Button private lateinit var btnCalculate:Button

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
        val intent = Intent(this,DetailedViewScreen::class.java)
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
        val averageTemperaturaForTheWeek =calculateAverageTemperatureForTheWeek()
        Toast.makeText(this,"Average Temperature For The Week: $averageTemperaturaForTheWeek",Toast.LENGTH_SHORT).show()
        }

    }
private fun calculateAverageTemperatureForTheWeek():Double {
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
            //Handle invalid input
            Toast.makeText(this, "Invalid input:$e", Toast.LENGTH_SHORT).show()
}
