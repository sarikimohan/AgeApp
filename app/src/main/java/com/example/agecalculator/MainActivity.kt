package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDob = findViewById<Button>(R.id.buttonDob)

        buttonDob.setOnClickListener { view ->
            age(view)
        }


    }

    private fun age(view: View?) {
        var myCalendar = Calendar.getInstance()
        var year = myCalendar.get(Calendar.YEAR)
        var month = myCalendar.get(Calendar.MONTH)
        var day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->

            val dateOfBirth = "$day / ${month + 1} / $year"
            var bod = findViewById<TextView>(R.id.bod)
            bod.text = dateOfBirth.toString()

            var dobText=findViewById<TextView>(R.id.dobText)

            var birth=Calendar.getInstance()
            birth.set(year,month,day)

            var age= myCalendar.get(Calendar.YEAR)-birth.get(Calendar.YEAR)
            if(myCalendar.get(Calendar.DAY_OF_YEAR)<birth.get(Calendar.DAY_OF_YEAR)){
                age--
            }

            dobText.text= "You are $age years old"

        },  year,
            month,
            day).show()

    }
}