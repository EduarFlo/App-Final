package com.example.finalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_rfc_generator.*

class Rfc_generator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rfc_generator)
        date.setOnClickListener{ showDatePickerDialog() }

        val btnGenerate = findViewById<Button>(R.id.generar)
        val btnBorrar = findViewById<Button>(R.id.borrar)
        val name = findViewById<EditText>(R.id.nombre)
        val apellidoPat = findViewById<EditText>(R.id.apellidosP)
        val apellidoMat = findViewById<EditText>(R.id.apellidosM)


        btnBorrar.setOnClickListener{
            name.setText("")
            apellidoPat.setText("")
            apellidoMat.setText("")
            date.setText("")
        }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }


    fun onDateSelected(day: Int, month: Int, year: Int) {
        date.setText("$day/$month/$year")
    }

}