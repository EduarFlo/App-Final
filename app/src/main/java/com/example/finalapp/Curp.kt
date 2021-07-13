package com.example.finalapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_curp.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class Curp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curp)

        var sexo = ""
        val valores = mutableListOf("0","1","2","3","4","5","6","7","8","9")
        var estados = arrayOf("AS-Aguascalientes","BC-Baja California","BS-Baja California Sur","CC-Campeche","CL-Coahuila","CM-Colima","CS-Chiapas",
            "CH-Chihuahua","DG-Durango","GT-Guanajuato","GR-Guerrero","HG-Hidalgo","JC-Jalisco","MC-México","MN-Michoacán","MS-Morelos","NT-Nayarit",
            "NL-Nuevo León","OC-Oaxaca","PL-Puebla","QT-Querétaro","QR-Quintana Roo","SP-San Luis Potosí","SL-Sinaloa","SR-Sonora","TC-Tabasco","TS-Tamaulipas",
            "TL-Tlaxcala","VZ-Veracruz","YN-Yucatan","ZS-Zacatecas","NE-Nacido en el Extrenjero")

        val arrayAdapter = ArrayAdapter(this@Curp,android.R.layout.simple_spinner_dropdown_item,estados)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val estado = (estados[position])
                Estadotxt.setText(estado)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
        //Calendario para selesccionar la fecha de nacimiento

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        //Boton para desplegar el Date Picker Dialog para poder seleccionar el dia, mes año de nacimiento
        fechabtn.setOnClickListener {
            var dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                //se le asigna a una variable llamada mes el valor de mMonth+1 ya que por defualt se agrega los meses con 1 de diferencia y posteriormente es pasado a un valor STRING
                var mes = (mMonth+1).toString()
                //si el valor de mes en INT es menor a 10 al momento de imprimir seria 1,2,3.... y para el caso del curp se debe presentar como 01,02,03......
                //entonces si el valor es menor a 10 se le agrega un 0 antes para cumplir el como lo necesita el curp
                if (mes.toInt()<10){
                    mes = "0" + mes
                }
                //AL igual que con los meses los dias inferiores a 10 se presentan como 1,2,3...... y para el uso del curp se debe presentar como 01,02,03
                //entonces si el valor del dia es menor a 10 se le agrega un 0 antes
                var dia = (mDay).toString()
                if (dia.toInt()<10){
                    dia = "0" + dia
                }
                //Tengo un txt donde se muestra fecha una ves seleccionado con el formato DD/MM/YY el formato no afecta a la creacion del curp solo al aocomodo de los valores
                fechatxt.setText(""+ dia + "/" + (mes) + "/" + mYear)},year, month, day)
            //Se muestra el Date Picker
            dpd.show()
        }

        radio_G.setOnCheckedChangeListener { group, i ->
            if (i == R.id.radio_H)
                sexo = radio_H.text[0].toString()
            Toast.makeText(this,sexo,Toast.LENGTH_SHORT).show()
            if (i == R.id.radio_M)
                sexo = radio_M.text[0].toString()
            Toast.makeText(this,sexo,Toast.LENGTH_SHORT).show()
        }


        btncrear.setOnClickListener {
            val nombre = nombretxt.text;
            val apellido1 = apellidotxt.text
            val apellido2 = apellido2txt.text
            var apellidoVocal = removerconsonante(apellido1.toString())
            val fecha = fechatxt.text.toString()
            val consonanteapellido1 = removervocal(apellido1.toString())
            val consonanteapellido2 = removervocal(apellido2.toString())
            val consonantenombre = removervocal(nombre.toString())
            var valor2 = ""
            var valor14 = ""
            var valor15 = ""
            var valor16 = ""
            if (apellido1[0].toLowerCase() == 'a'|| apellido1[0].toLowerCase() == 'e'|| apellido1[0].toLowerCase() == 'i'|| apellido1[0].toLowerCase() == 'o'|| apellido1[0].toLowerCase() == 'u' ){
                valor2 = apellidoVocal[1].toString().toUpperCase()
            }
            else{
                valor2 = apellidoVocal[0].toString().toUpperCase()
            }
            if (apellido1[0].toLowerCase() == 'a'|| apellido1[0].toLowerCase() == 'e'|| apellido1[0].toLowerCase() == 'i'|| apellido1[0].toLowerCase() == 'o'|| apellido1[0].toLowerCase() == 'u' ){
                valor14 = consonanteapellido1[0].toString().toUpperCase()
            }
            else{
                valor14 = consonanteapellido1[1].toString().toUpperCase()
            }
            if (apellido2[0].toLowerCase() == 'a'|| apellido2[0].toLowerCase() == 'e'|| apellido2[0].toLowerCase() == 'i'|| apellido2[0].toLowerCase() == 'o'|| apellido2[0].toLowerCase() == 'u' ){
                valor15 = consonanteapellido2[0].toString().toUpperCase()
            }
            else{
                valor15 = consonanteapellido2[1].toString().toUpperCase()
            }
            if (nombre[0].toLowerCase() == 'a'|| nombre[0].toLowerCase() == 'e'|| nombre[0].toLowerCase() == 'i'|| nombre[0].toLowerCase() == 'o'|| nombre[0].toLowerCase() == 'u' ){
                valor16 = consonantenombre[0].toString().toUpperCase()
            }
            else{
                valor16 = consonantenombre[1].toString().toUpperCase()
            }

            if(nombre.length == 0 || apellido1.length == 0 || apellido2.length == 0){
                Toast.makeText(this,"alguno de los campos esta vacio",Toast.LENGTH_SHORT).show()
            }
            else{
                var valor1 = apellido1[0].toString().toUpperCase()
                var valor3 = apellido2[0].toString().toUpperCase()
                var valor4 = nombre[0].toString().toUpperCase()
                var valor5 = fecha[8]
                var valor6 = fecha[9]
                var valor7 = fecha[3]
                var valor8 = fecha[4]
                var valor9 = fecha[0]
                var valor10 = fecha[1]
                var valor11 = sexo
                var valor12 = Estadotxt.text[0]
                var valor13 = Estadotxt.text[1]
                val valor17 = valores.random()
                val valor18 = valores.random()

                curp.text = valor1 + valor2 + valor3 + valor4 + valor5 + valor6 + valor7 + valor8 + valor9 + valor10 + valor11 + valor12 + valor13 + valor14 + valor15 + valor16 + valor17 + valor18
            }

        }
        btnlimpiar.setOnClickListener {
            var nombre = findViewById<EditText>(R.id.nombretxt)
            nombre.text.clear()
            var apellido = findViewById<EditText>(R.id.apellidotxt)
            apellido.text.clear()
            var apellido2 = findViewById<EditText>(R.id.apellido2txt)
            apellido2.text.clear()
            var fecha = findViewById<TextView>(R.id.fechatxt)
            fecha.setText("Fecha")
            var estado = findViewById<TextView>(R.id.Estadotxt)
            estado.setText("Estado")
            var curp = findViewById<TextView>(R.id.curp)
            curp.setText("CURP")
        }
    }

    fun removerconsonante( text: String ): String {
        val result = StringBuilder()
        for ( char in text ) {
            if ( !"bcdfghjklmnñpqrstvwxyz".contains(char.toLowerCase()) ) {
                result.append( char )
            }
        }
        return result.toString()
    }

    fun removervocal( text: String ): String {
        val result = StringBuilder()
        for ( char in text ) {
            if ( !"aeiou".contains(char.toLowerCase()) ) {
                result.append( char )
            }
        }
        return result.toString()
    }

}